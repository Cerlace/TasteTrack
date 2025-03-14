package cerlace.tastetrack.web.controller;

import cerlace.tastetrack.core.exception.PasswordConfirmException;
import cerlace.tastetrack.web.alert.Alert;
import cerlace.tastetrack.core.dto.DietDiaryDTO;
import cerlace.tastetrack.core.dto.MealDTO;
import cerlace.tastetrack.core.dto.UserDTO;
import cerlace.tastetrack.web.alert.AlertCode;
import cerlace.tastetrack.web.alert.AlertMessage;
import cerlace.tastetrack.core.service.DishService;
import cerlace.tastetrack.core.service.MealService;
import cerlace.tastetrack.core.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
@PreAuthorize("isAuthenticated()")
public class AuthUserController {

    public static final String PASSWORD_CONFIRM_EXCEPTION_MESSAGE = "Password and confirm password don't match!";
    private final MealService mealService;
    private final UserService userService;
    private final UserDetailsPasswordService userDetailsPasswordService;
    private final DishService dishService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

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
        return "user/form-profile";
    }

    /**
     * Обрабатывает отправку формы редактирования профиля пользователя.
     *
     * @param userDetails        объект {@link UserDetails}, содержащий информацию о текущем пользователе.
     * @param user               объект {@link UserDTO}, содержащий обновленные данные пользователя.
     * @param bindingResult      объект {@link BindingResult}, содержащий результаты валидации и ошибки,
     *                           связанные с объектом {@link UserDTO}.
     * @param redirectAttributes объект {@link RedirectAttributes} для передачи сообщений через перенаправление.
     * @return перенаправление на страницу профиля.
     */
    @PostMapping("/profile/edit")
    public String edit(@AuthenticationPrincipal UserDetails userDetails,
                       @Valid
                       @ModelAttribute("user") UserDTO user,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        user.setUsername(userDetails.getUsername());
        if (bindingResult.hasErrors()) {
            return "user/form-profile";
        }
        userService.editDetails(user);
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
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
        return "user/form-password";
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
        if (!Objects.equals(user.getPassword(), user.getPasswordConfirm()) ||
                !bCryptPasswordEncoder.matches(user.getOldPassword(), userDetails.getPassword())) {
            throw new PasswordConfirmException(PASSWORD_CONFIRM_EXCEPTION_MESSAGE);
        }
        userDetailsPasswordService.updatePassword(userDetails, bCryptPasswordEncoder.encode(user.getPassword()));
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
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
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.ACCOUNT_DELETED)
                .build());
        return "redirect:/dishes";
    }

    /**
     * Получает дневник питания
     *
     * @param userDetails объект {@link UserDetails}, содержащий информацию о текущем пользователе.
     * @param inputDate   дата, определяющая неделю по которой будет выведен дневник питания.
     * @param model       объект {@link Model} для передачи данных в представление.
     * @return имя представления.
     */
    @GetMapping("/diary")
    public String getUserDietDiary(@AuthenticationPrincipal UserDetails userDetails,
                                   @RequestParam(required = false) LocalDate inputDate,
                                   Model model) {
        DietDiaryDTO diary = mealService.getDietDiary(userDetails.getUsername(), inputDate);
        model.addAttribute("diary", diary);
        model.addAttribute("previousWeek", diary.getStartDate().minusWeeks(1));
        model.addAttribute("nextWeek", diary.getStartDate().plusWeeks(1));
        return "meal/diary";
    }

    /**
     * Отображает форму для создания нового приема пищи.
     *
     * @param userDetails объект {@link UserDetails}, содержащий информацию о текущем пользователе.
     * @param date        дата, для которой необходимо создать прием пищи.
     * @param model       объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы создания приема пищи.
     */
    @GetMapping("/diary/create")
    public String showCreateMealForm(@AuthenticationPrincipal UserDetails userDetails,
                                     @RequestParam LocalDate date,
                                     Model model) {
        MealDTO newMeal = MealDTO.builder()
                .user(UserDTO.builder()
                        .id(userService.getByUsername(userDetails.getUsername()).getId())
                        .build())
                .date(date)
                .build();
        model.addAttribute("meal", newMeal);
        model.addAttribute("dishesList", dishService.getAll());
        return "meal/form-diary-meal";
    }

    /**
     * Сохраняет данные приема пищи.
     *
     * @param meal               объект {@link MealDTO}, содержащий данные приема пищи.
     * @param inputDate          дата, с которой необходимо вывести дневник питания после перенаправления.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком приемов пищи.
     */
    @PostMapping("/diary/save")
    public String save(@ModelAttribute("meal") MealDTO meal,
                       @RequestParam(required = false) LocalDate inputDate,
                       RedirectAttributes redirectAttributes) {
        mealService.save(meal);
        redirectAttributes.addAttribute("inputDate", inputDate);
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.SAVED)
                .build());
        return "redirect:/diary";
    }

    /**
     * Удаляет прием пищи по его идентификатору.
     *
     * @param mealId             идентификатор приема пищи, который нужно удалить.
     * @param inputDate          дата, с которой необходимо вывести дневник питания после перенаправления.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком приемов пищи.
     */
    @PostMapping("/diary/delete")
    public String delete(@RequestParam Long mealId,
                         @RequestParam(required = false) LocalDate inputDate,
                         RedirectAttributes redirectAttributes) {
        mealService.delete(mealId);
        redirectAttributes.addAttribute("inputDate", inputDate);
        redirectAttributes.addFlashAttribute("alert", Alert.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.DELETED)
                .build());
        return "redirect:/diary";
    }
}
