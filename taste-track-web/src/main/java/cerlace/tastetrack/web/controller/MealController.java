package cerlace.tastetrack.web.controller;

import cerlace.tastetrack.web.alert.Alert;
import cerlace.tastetrack.core.dto.DietDiaryDTO;
import cerlace.tastetrack.core.dto.MealDTO;
import cerlace.tastetrack.core.dto.UserDTO;
import cerlace.tastetrack.web.alert.AlertCode;
import cerlace.tastetrack.web.alert.AlertMessage;
import cerlace.tastetrack.core.service.DishService;
import cerlace.tastetrack.core.service.MealService;
import lombok.RequiredArgsConstructor;
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

import java.time.LocalDate;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users/{userId}/meals")
@PreAuthorize("hasRole('ADMIN')")
public class MealController {

    private final MealService mealService;
    private final DishService dishService;

    /**
     * Отображает страницу дневника питания указанного пользователя.
     *
     * @param userId    идентификатор пользователя, для которого нужно отобразить дневник питания.
     * @param inputDate дата, определяющая неделю по которой будет выведен дневник питания.
     * @param model     объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения списка приемов пищи.
     */
    @GetMapping
    public String getUserDietDiary(@PathVariable("userId") Long userId,
                                   @RequestParam(required = false) LocalDate inputDate,
                                   Model model) {
        DietDiaryDTO diary = mealService.getDietDiary(userId, inputDate);
        model.addAttribute("diary", diary);
        model.addAttribute("previousWeek", diary.getStartDate().minusWeeks(1));
        model.addAttribute("nextWeek", diary.getStartDate().plusWeeks(1));
        return "meal/user-diary";
    }

    /**
     * Отображает форму для создания нового приема пищи.
     *
     * @param userId идентификатор пользователя, к которому относится прием пищи.
     * @param date   дата, для которой необходимо создать прием пищи.
     * @param model  объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы создания приема пищи.
     */
    @GetMapping("/create")
    public String showCreateForm(@PathVariable("userId") Long userId,
                                 @RequestParam LocalDate date,
                                 Model model) {
        MealDTO newMeal = MealDTO.builder()
                .user(UserDTO.builder()
                        .id(userId)
                        .build())
                .date(date)
                .build();
        model.addAttribute("meal", newMeal);
        model.addAttribute("dishesList", dishService.getAll());
        return "meal/form-meal";
    }

    /**
     * Сохраняет данные приема пищи.
     *
     * @param meal               объект {@link MealDTO}, содержащий данные приема пищи.
     * @param userId             идентификатор пользователя, к которому относится прием пищи.
     * @param inputDate          дата, с которой необходимо вывести дневник питания после перенаправления.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком приемов пищи.
     */
    @PostMapping("/save")
    public String save(@ModelAttribute("meal") MealDTO meal,
                       @PathVariable("userId") Long userId,
                       @RequestParam(required = false) LocalDate inputDate,
                       RedirectAttributes redirectAttributes) {
        mealService.save(meal);
        redirectAttributes.addAttribute("inputDate", inputDate);
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
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
     * @param inputDate          дата, с которой необходимо вывести дневник питания после перенаправления.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком приемов пищи.
     */
    @PostMapping("/delete/{mealId}")
    public String delete(@PathVariable Long mealId,
                         @PathVariable("userId") Long userId,
                         @RequestParam(required = false) LocalDate inputDate,
                         RedirectAttributes redirectAttributes) {
        mealService.delete(mealId);
        redirectAttributes.addAttribute("inputDate", inputDate);
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.DELETED)
                .build());
        return "redirect:/users/%d/meals".formatted(userId);
    }
}
