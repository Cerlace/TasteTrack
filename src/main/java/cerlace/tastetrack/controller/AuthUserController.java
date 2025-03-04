package cerlace.tastetrack.controller;

import cerlace.tastetrack.dto.AlertDTO;
import cerlace.tastetrack.dto.DietDiaryDTO;
import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.enums.AlertMessage;
import cerlace.tastetrack.enums.Gender;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.service.MealService;
import cerlace.tastetrack.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@RequiredArgsConstructor
@Controller
@PreAuthorize("isAuthenticated()")
public class AuthUserController {

    private final MealService mealService;
    private final UserService userService;

    /**
     * Отображает профиль пользователя.
     *
     * @param userDetails данные авторизованного пользователя
     * @param model       объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения списка пользователей.
     */
    @GetMapping("/profile")
    public String profile(@AuthenticationPrincipal UserDetails userDetails,
                          Model model) {
        model.addAttribute("user", userService.getByUsername(userDetails.getUsername()));
        return "user/profile";
    }

    /**
     * Отображает форму редактирования профиля пользователя.
     *
     * @param userDetails объект {@link UserDetails}, содержащий информацию о текущем пользователе.
     * @param model       объект {@link Model} для передачи данных в представление.
     * @return имя представления.
     */
    @GetMapping("/profile/edit")
    public String showEditForm(@AuthenticationPrincipal UserDetails userDetails,
                               Model model) {
        model.addAttribute("user", userService.getByUsername(userDetails.getUsername()));
        model.addAttribute("genders", Gender.values());
        model.addAttribute("activityLevels", Activity.values());
        model.addAttribute("goals", Goal.values());
        return "user/form-profile";
    }

    /**
     * Обрабатывает отправку формы редактирования профиля пользователя.
     *
     * @param userDetails        объект {@link UserDetails}, содержащий информацию о текущем пользователе.
     * @param user               объект {@link UserDTO}, содержащий обновленные данные пользователя.
     * @param redirectAttributes объект {@link RedirectAttributes} для передачи сообщений через перенаправление.
     * @return перенаправление на страницу профиля.
     */
    @PostMapping("/profile/edit")
    public String edit(@AuthenticationPrincipal UserDetails userDetails,
                       @ModelAttribute("user") UserDTO user,
                       RedirectAttributes redirectAttributes) {
        user.setUsername(userDetails.getUsername());
        userService.editDetails(user);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.PROFILE_UPDATED)
                .build());
        return "redirect:/profile";
    }

    /**
     * Отображает форму для смены пароля пользователя.
     *
     * @param model объект {@link Model} для передачи данных в представление.
     * @return имя представления.
     */
    @GetMapping("/profile/change-password")
    public String showChangePasswordForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/form-profile";
    }

    /**
     * Обрабатывает отправку формы смены пароля пользователя.
     *
     * @param userDetails        объект {@link UserDetails}, содержащий информацию о текущем пользователе.
     * @param user               объект {@link UserDTO}, содержащий данные для смены пароля.
     * @param redirectAttributes объект {@link RedirectAttributes} для передачи сообщений через перенаправление.
     * @return перенаправление на страницу профиля.
     */
    @PostMapping("/profile/change-password")
    public String changePassword(@AuthenticationPrincipal UserDetails userDetails,
                                 @ModelAttribute("user") UserDTO user,
                                 RedirectAttributes redirectAttributes) {
        user.setUsername(userDetails.getUsername());
        userService.changePassword(user);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.PASSWORD_CHANGED)
                .build());
        return "redirect:/profile";
    }

    /**
     * Удаляет учетную запись пользователя и завершает его сессию.
     *
     * @param userDetails        объект {@link UserDetails}, содержащий информацию о текущем пользователе.
     * @param request            объект {@link HttpServletRequest} для выполнения операции logout.
     * @param redirectAttributes объект {@link RedirectAttributes} для передачи сообщений через перенаправление.
     * @return перенаправление на стартовую страницу".
     * @throws ServletException если возникает ошибка при завершении сессии пользователя.
     */
    @PostMapping("/profile/remove")
    public String remove(@AuthenticationPrincipal UserDetails userDetails,
                         HttpServletRequest request,
                         RedirectAttributes redirectAttributes) throws ServletException {
        request.logout();
        userService.deleteByUsername(userDetails.getUsername());
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.ACCOUNT_DELETED)
                .build());
        return "redirect:/dishes";
    }

    /**
     * Получает дневник питания
     * @param userDetails  объект {@link UserDetails}, содержащий информацию о текущем пользователе.
     * @param inputDate дата
     * @param model объект {@link Model} для передачи данных в представление.
     * @return имя представления.
     */
    @GetMapping("/diary")
    public String getUserDietDiary(@AuthenticationPrincipal UserDetails userDetails,
                                   @RequestParam(required = false)
                                   @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate inputDate,
                                   Model model) {
        DietDiaryDTO diary = mealService.getDietDiary(userDetails.getUsername(), inputDate);
        model.addAttribute("diary", diary);
        model.addAttribute("startDate", diary.getStartDate());
        model.addAttribute("previousWeek", diary.getStartDate().minusWeeks(1));
        model.addAttribute("nextWeek", diary.getStartDate().plusWeeks(1));
        return "meal/diary";
    }
}
