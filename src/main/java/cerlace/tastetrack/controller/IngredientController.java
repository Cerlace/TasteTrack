package cerlace.tastetrack.controller;

import cerlace.tastetrack.dto.AlertDTO;
import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.enums.AlertMessage;
import cerlace.tastetrack.enums.ProductType;
import cerlace.tastetrack.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
@RequestMapping("/ingredients")
public class IngredientController {

    private final IngredientService ingredientService;

    /**
     * Отображает список всех ингредиентов.
     *
     * @param model объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения списка ингредиентов.
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("ingredientList", ingredientService.getAll());
        return "ingredient/list-ingredient";
    }

    /**
     * Отображает форму для создания нового ингредиента.
     *
     * @param model объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы создания ингредиента.
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("ingredient", new IngredientDTO());
        model.addAttribute("productTypes", ProductType.values());
        return "ingredient/form-ingredient";
    }

    /**
     * Отображает форму для редактирования существующего ингредиента.
     *
     * @param ingredientId идентификатор ингредиента, который нужно отредактировать.
     * @param model        объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы редактирования ингредиента.
     */
    @GetMapping("/edit/{ingredientId}")
    public String showEditForm(@PathVariable("ingredientId") Long ingredientId, Model model) {
        model.addAttribute("ingredient", ingredientService.get(ingredientId));
        model.addAttribute("productTypes", ProductType.values());
        return "ingredient/form-ingredient";
    }

    /**
     * Сохраняет или обновляет данные ингредиента.
     *
     * @param ingredient         объект {@link IngredientDTO}, содержащий данные ингредиента.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return строка перенаправления на страницу со списком ингредиентов.
     */
    @PostMapping("/save")
    public String saveOrUpdate(@ModelAttribute("ingredient") IngredientDTO ingredient,
                               RedirectAttributes redirectAttributes) {
        ingredientService.saveOrUpdate(ingredient);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.SAVED)
                .build());
        return "redirect:/ingredients";
    }

    /**
     * Удаляет ингредиент по его идентификатору.
     *
     * @param ingredientId       идентификатор ингредиента, который нужно удалить.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком ингредиентов.
     */
    @PostMapping("/delete/{ingredientId}")
    public String deleteUser(@PathVariable Long ingredientId,
                             RedirectAttributes redirectAttributes) {
        ingredientService.delete(ingredientId);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.DELETED)
                .build());
        return "redirect:/ingredients";
    }
}
