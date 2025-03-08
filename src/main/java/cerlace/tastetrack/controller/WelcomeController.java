package cerlace.tastetrack.controller;

import cerlace.tastetrack.dto.AlertDTO;
import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.enums.AlertMessage;
import cerlace.tastetrack.enums.Gender;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.exception.PasswordConfirmException;
import cerlace.tastetrack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
public class WelcomeController {

    public static final String PASSWORD_CONFIRM_MESSAGE = "Password and password confirm not same!";
    private final UserService userService;

    /**
     * Перенаправляет на начальную страницу.
     *
     * @return редирект на начальную страницу.
     */
    @GetMapping("/")
    public String redirectToHomePage() {
        return "redirect:/dishes";
    }

    /**
     * Отображает страницу логина.
     *
     * @return имя представления страницы логина.
     */
    @GetMapping("/login")
    String login() {
        return "login";
    }

    /**
     * Отображает форму регистрации пользователя.
     *
     * @param model объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления формы регистрации.
     */
    @GetMapping("/registration")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new UserDTO());
        model.addAttribute("genders", Gender.values());
        model.addAttribute("activityLevels", Activity.values());
        model.addAttribute("goals", Goal.values());
        return "registration";
    }

    /**
     * Обрабатывает запрос на регистрацию пользователя.
     *
     * @param user               объект UserDTO, содержащий данные пользователя из формы регистрации.
     * @param redirectAttributes атрибуты для перенаправления, используемые для добавления уведомлений об ошибке.
     * @return редирект на страницу логина после успешной регистрации.
     * @throws PasswordConfirmException если пароль и подтверждение пароля не совпадают.
     */
    @PostMapping("/registration")
    public String register(@ModelAttribute("user") UserDTO user,
                           RedirectAttributes redirectAttributes) {
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            throw new PasswordConfirmException(PASSWORD_CONFIRM_MESSAGE);
        }
        userService.saveOrUpdate(user);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.SAVED)
                .build());
        return "redirect:/login";
    }
}
