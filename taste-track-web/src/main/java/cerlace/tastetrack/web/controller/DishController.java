package cerlace.tastetrack.web.controller;

import cerlace.tastetrack.web.alert.Alert;
import cerlace.tastetrack.core.dto.DishDTO;
import cerlace.tastetrack.core.dto.DishFilter;
import cerlace.tastetrack.core.dto.IngredientDTO;
import cerlace.tastetrack.core.dto.PageSettings;
import cerlace.tastetrack.web.alert.AlertCode;
import cerlace.tastetrack.web.alert.AlertMessage;
import cerlace.tastetrack.core.service.DishService;
import cerlace.tastetrack.core.service.IngredientService;
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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;
    private final IngredientService ingredientService;

    /**
     * Добавляет список всех ингредиентов в модель.
     *
     * @return список всех ингредиентов в виде {@link List < IngredientDTO >}.
     */
    @ModelAttribute("ingredientsList")
    public List<IngredientDTO> addIngredientsToModel() {
        return ingredientService.getAll();
    }

    /**
     * Отображает детали о блюде
     *
     * @param dishId  идентификатор блюда.
     * @param request объект {@link WebRequest}, содержащий информацию о запросе.
     * @param model   объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения деталей блюда.
     */
    @GetMapping("/{dishId}")
    public String details(@PathVariable("dishId") Long dishId,
                          WebRequest request,
                          Model model) {
        model.addAttribute("dish", dishService.getDetailed(dishId));
        model.addAttribute("referer", request.getHeader("referer"));
        return "dish/show-dish";
    }

    /**
     * Отображает страницу блюд.
     *
     * @param filter       параметры для фильтрации страницы
     * @param pageSettings параметры для запроса страницы
     * @param model        объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения списка блюд.
     */
    @GetMapping
    public String list(@ModelAttribute("filter") DishFilter filter,
                       @ModelAttribute PageSettings pageSettings,
                       Model model) {
        Page<DishDTO> page = dishService.getFilteredPage(pageSettings, filter);
        model.addAttribute("dishList", page.getContent());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("filter", filter);
        model.addAttribute("pageSettings", pageSettings);
        return "dish/list-dish";
    }

    /**
     * Отображает форму для создания нового блюда.
     *
     * @param model объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы создания блюда.
     */
    @GetMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public String showCreateForm(Model model) {
        model.addAttribute("dish", new DishDTO());
        return "dish/form-dish";
    }

    /**
     * Отображает форму для редактирования существующего блюда.
     *
     * @param dishId идентификатор блюда, которое нужно отредактировать.
     * @param model  объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы редактирования блюда.
     */
    @GetMapping("/edit/{dishId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String showEditForm(@PathVariable("dishId") Long dishId, Model model) {
        model.addAttribute("dish", dishService.get(dishId));
        return "dish/form-dish";
    }

    /**
     * Сохраняет или обновляет данные блюда.
     *
     * @param dish               объект {@link DishDTO}, содержащий данные блюда.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком блюд.
     */
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public String saveOrUpdate(@ModelAttribute("dish") DishDTO dish,
                               RedirectAttributes redirectAttributes) {
        dishService.saveOrUpdate(dish);
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.SAVED)
                .build());
        return "redirect:/dishes";
    }

    /**
     * Удаляет блюдо по его идентификатору.
     *
     * @param dishId             идентификатор блюда, которое нужно удалить.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком блюд.
     */
    @PostMapping("/delete/{dishId}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable Long dishId,
                         RedirectAttributes redirectAttributes) {
        dishService.delete(dishId);
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.DELETED)
                .build());
        return "redirect:/dishes";
    }
}
