package cerlace.tastetrack.controller;

import cerlace.tastetrack.dto.AlertDTO;
import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.enums.AlertMessage;
import cerlace.tastetrack.enums.DishType;
import cerlace.tastetrack.service.DishService;
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
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    /**
     * Отображает список всех блюд.
     *
     * @param model объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения списка блюд.
     */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("dishList", dishService.getAll());
        return "dish/list-dish";
    }

    /**
     * Отображает форму для создания нового блюда.
     *
     * @param model объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы создания блюда.
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("dish", new DishDTO());
        model.addAttribute("dishTypes", DishType.values());
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
    public String showEditForm(@PathVariable("dishId") Long dishId, Model model) {
        model.addAttribute("dish", dishService.get(dishId));
        model.addAttribute("dishTypes", DishType.values());
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
    public String saveOrUpdate(@ModelAttribute("dish") DishDTO dish,
                               RedirectAttributes redirectAttributes) {
        dishService.saveOrUpdate(dish);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
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
    public String deleteUser(@PathVariable Long dishId,
                             RedirectAttributes redirectAttributes) {
        dishService.delete(dishId);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.DELETED)
                .build());
        return "redirect:/dishes";
    }
}
