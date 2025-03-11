package cerlace.tastetrack.controller;

import cerlace.tastetrack.dto.AlertDTO;
import cerlace.tastetrack.dto.PageSettings;
import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.enums.AlertMessage;
import cerlace.tastetrack.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
@Controller
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    private final UserService userService;

    /**
     * Отображает страницу пользователей.
     *
     * @param pageSettings параметры для запроса страницы
     * @param model        объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения списка пользователей.
     */
    @GetMapping
    public String list(@ModelAttribute PageSettings pageSettings,
                       Model model) {
        Page<UserDTO> page = userService.getPage(pageSettings);
        model.addAttribute("userList", page.getContent());
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("pageSettings", pageSettings);
        return "user/list-user";
    }

    /**
     * Отображает форму для создания нового пользователя.
     *
     * @param model объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы создания пользователя.
     */
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "user/form-user";
    }

    /**
     * Отображает форму для редактирования существующего пользователя.
     *
     * @param userId идентификатор пользователя, который необходимо отредактировать.
     * @param model  объект {@link Model}, используемый для передачи данных в представление.
     * @return имя представления для отображения формы редактирования пользователя.
     */
    @GetMapping("/edit/{userId}")
    public String showEditForm(@PathVariable("userId") Long userId, Model model) {
        model.addAttribute("user", userService.get(userId));
        return "user/form-user";
    }

    /**
     * Сохраняет или обновляет данные пользователя.
     *
     * @param user               объект {@link UserDTO}, содержащий данные пользователя.
     * @param bindingResult      объект {@link BindingResult}, содержащий результаты валидации и ошибки,
     *                           связанные с объектом {@link UserDTO}.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправление на страницу со списком пользователей.
     */
    @PostMapping("/save")
    public String saveOrUpdate(@Valid
                               @ModelAttribute("user") UserDTO user,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "user/form-user";
        }
        userService.saveOrUpdate(user);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.SAVED)
                .build());
        return "redirect:/users";
    }

    /**
     * Удаляет пользователя по его идентификатору.
     *
     * @param userId             идентификатор пользователя, который необходимо удалить.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи атрибутов при редиректе.
     * @return перенаправления на страницу со списком пользователей.
     */
    @PostMapping("/delete/{userId}")
    public String delete(@PathVariable Long userId,
                         RedirectAttributes redirectAttributes) {
        userService.delete(userId);
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.SUCCESS)
                .alertMessage(AlertMessage.DELETED)
                .build());
        return "redirect:/users";
    }
}
