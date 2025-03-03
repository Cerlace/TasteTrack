package cerlace.tastetrack.controller;

import cerlace.tastetrack.dto.AlertDTO;
import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.enums.AlertMessage;
import cerlace.tastetrack.enums.MeasureUnit;
import cerlace.tastetrack.service.DishIngredientService;
import cerlace.tastetrack.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/dish-ingredients")
public class DishIngredientController {

    private final DishIngredientService dishIngredientService;
    private final IngredientService ingredientService;

    /**
     * Добавляет список всех ингредиентов в модель.
     *
     * @return список всех ингредиентов в виде {@link List<IngredientDTO>}.
     */
    @ModelAttribute("ingredientsList")
    public List<IngredientDTO> addIngredientsToModel() {
        return ingredientService.getAll();
    }

    /**
     * Отображает страницу ингредиентов для указанного блюда.
     *
     * @param pageSettings параметры для запроса страницы
     * @param dishId       идентификатор блюда, для которого нужно отобразить ингредиенты.
     * @param model        объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения списка ингредиентов блюда.
     */
    @GetMapping("/{dishId}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public String listDishIngredients(@ModelAttribute PageSettings pageSettings,
                                      @PathVariable("dishId") Long dishId,
                                      Model model) {
        Page<DishIngredientDTO> page = dishIngredientService.getPageOfIngredientsByDish(pageSettings, dishId);
        model.addAttribute("dishIngredientList", page.getContent());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("pageSettings", pageSettings);
        return "dish-ingredient/list-dish-ingredient";
    }

    /**
     * Отображает форму для создания нового ингредиента блюда.
     *
     * @param dishId идентификатор блюда, которому принадлежит ингредиент.
     * @param model  объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы создания ингредиента блюда.
     */
    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(@RequestParam("dishId") Long dishId, Model model) {
        model.addAttribute("dishId", dishId);
        model.addAttribute("dishIngredient", new DishIngredientDTO());
        model.addAttribute("measureUnits", MeasureUnit.values());
        return "dish-ingredient/form-dish-ingredient";
    }

    /**
     * Отображает форму для редактирования существующего ингредиента блюда.
     *
     * @param dishIngredientId идентификатор ингредиента блюда, который нужно отредактировать.
     * @param dishId           идентификатор блюда, которому принадлежит ингредиент.
     * @param model            объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы редактирования ингредиента блюда.
     */
    @GetMapping("/edit/{dishIngredientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@RequestParam("dishId") Long dishId,
                               @PathVariable("dishIngredientId") Long dishIngredientId,
                               Model model) {
        model.addAttribute("dishId", dishId);
        model.addAttribute("dishIngredient", dishIngredientService.get(dishIngredientId));
        model.addAttribute("measureUnits", MeasureUnit.values());
        return "dish-ingredient/form-dish-ingredient";
    }

    /**
     * Сохраняет или обновляет данные ингредиента блюда.
     *
     * @param dishIngredient     объект {@link DishIngredientDTO}, содержащий данные ингредиента блюда.
     * @param dishId             идентификатор блюда, которому принадлежит ингредиент.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком ингредиентов блюда.
     */
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveOrUpdate(@ModelAttribute("dishIngredient") DishIngredientDTO dishIngredient,
                               @ModelAttribute("dishId") Long dishId,
                               RedirectAttributes redirectAttributes) {
        dishIngredientService.saveOrUpdate(dishIngredient);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.SAVED)
                .build());
        return "redirect:/dish-ingredients/" + dishId;
    }

    /**
     * Удаляет ингредиент блюда по его идентификатору.
     *
     * @param dishIngredientId   идентификатор ингредиента блюда, который нужно удалить.
     * @param dishId             идентификатор блюда, которому принадлежит ингредиент.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком ингредиентов блюда.
     */
    @PostMapping("/delete/{dishIngredientId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long dishIngredientId,
                         @ModelAttribute("dishId") Long dishId,
                         RedirectAttributes redirectAttributes) {
        dishIngredientService.delete(dishIngredientId);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.DELETED)
                .build());
        return "redirect:/dish-ingredients/" + dishId;
    }
}
