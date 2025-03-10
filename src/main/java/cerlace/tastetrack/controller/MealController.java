package cerlace.tastetrack.controller;

import cerlace.tastetrack.dto.AlertDTO;
import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.enums.AlertMessage;
import cerlace.tastetrack.enums.MealTime;
import cerlace.tastetrack.service.DishService;
import cerlace.tastetrack.service.MealService;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users/{userId}/meals")
@PreAuthorize("hasRole('ADMIN')")
public class MealController {

    private final MealService mealService;
    private final DishService dishService;

    /**
     * Добавляет список всех блюд в модель.
     *
     * @return список всех блюд в виде {@link List<DishDTO>}.
     */
    @ModelAttribute("dishesList")
    public List<DishDTO> addDishesToModel() {
        return dishService.getAll();
    }

    /**
     * Отображает страницу приемов пищи для указанного пользователя.
     *
     * @param pageSettings параметры для запроса страницы
     * @param userId       идентификатор пользователя, для которого нужно отобразить приемы пищи.
     * @param model        объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения списка приемов пищи.
     */
    @GetMapping
    public String listUserMeals(@ModelAttribute PageSettings pageSettings,
                                @PathVariable("userId") Long userId,
                                Model model) {
        Page<MealDTO> page = mealService.getPageOfMealsByUser(pageSettings, userId);
        model.addAttribute("mealList", page.getContent());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("pageSettings", pageSettings);
        return "meal/list-meal";
    }

    /**
     * Отображает форму для создания нового приема пищи.
     *
     * @param userId идентификатор пользователя, к которому относится прием пищи.
     * @param model  объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы создания приема пищи.
     */
    @GetMapping("/create")
    public String showCreateForm(@PathVariable("userId") Long userId,
                                 Model model) {
        model.addAttribute("meal", new MealDTO());
        model.addAttribute("mealTimes", MealTime.values());
        return "meal/form-meal";
    }

    /**
     * Отображает форму для редактирования существующего приема пищи.
     *
     * @param mealId идентификатор приема пищи, который нужно отредактировать.
     * @param userId идентификатор пользователя, к которому относится прием пищи.
     * @param model  объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы редактирования приема пищи.
     */
    @GetMapping("/edit/{mealId}")
    public String showEditForm(@PathVariable("mealId") Long mealId,
                               @PathVariable("userId") Long userId,
                               Model model) {
        model.addAttribute("meal", mealService.get(mealId));
        model.addAttribute("mealTimes", MealTime.values());
        return "meal/form-meal";
    }

    /**
     * Сохраняет или обновляет данные приема пищи.
     *
     * @param meal               объект {@link MealDTO}, содержащий данные приема пищи.
     * @param userId             идентификатор пользователя, к которому относится прием пищи.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком приемов пищи.
     */
    @PostMapping("/save")
    public String saveOrUpdate(@ModelAttribute("meal") MealDTO meal,
                               @PathVariable("userId") Long userId,
                               RedirectAttributes redirectAttributes) {
        mealService.saveOrUpdate(meal);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.SAVED)
                .build());
        return "redirect:/users/%d/meals".formatted(userId);
    }

    /**
     * Удаляет прием пищи по его идентификатору.
     *
     * @param mealId             идентификатор приема пищи, который нужно удалить.
     * @param userId             идентификатор пользователя, к которому относится прием пищи.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком приемов пищи.
     */
    @PostMapping("/delete/{mealId}")
    public String delete(@PathVariable Long mealId,
                         @PathVariable("userId") Long userId,
                         RedirectAttributes redirectAttributes) {
        mealService.delete(mealId);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.DELETED)
                .build());
        return "redirect:/users/%d/meals".formatted(userId);
    }
}
