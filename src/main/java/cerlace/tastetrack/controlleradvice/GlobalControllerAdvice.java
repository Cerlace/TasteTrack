package cerlace.tastetrack.controlleradvice;

import cerlace.tastetrack.dto.AlertDTO;
import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.enums.AlertMessage;
import cerlace.tastetrack.exception.PasswordConfirmException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
public class GlobalControllerAdvice {
    /**
     * Обрабатывает исключение {@link SQLIntegrityConstraintViolationException}, которое возникает
     * при нарушении целостности данных в базе данных (например, при попытке вставить дублирующиеся
     * данные).
     *
     * <p>Добавляет атрибут "alert" в {@link RedirectAttributes}, который содержит информацию
     * о предупреждении, и перенаправляет пользователя на предыдущую страницу.</p>
     *
     * @param request            объект {@link WebRequest}, содержащий информацию о запросе.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи
     *                           атрибутов между запросами.
     * @return перенаправление на предыдущую страницу.
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public String handleConstraintViolation(WebRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.WARNING)
                .alertMessage(AlertMessage.CONSTRAINT)
                .build());

        return "redirect:" + request.getHeader("referer");
    }

    /**
     * Обрабатывает исключение {@link PasswordConfirmException}, которое возникает
     * при неудачном подтверждении пароля в форме регистрации или смены пароля.
     *
     * <p>Добавляет атрибут "alert" в {@link RedirectAttributes}, который содержит информацию
     * о предупреждении, и перенаправляет пользователя на предыдущую страницу.</p>
     *
     * @param request            объект {@link WebRequest}, содержащий информацию о запросе.
     * @param redirectAttributes объект {@link RedirectAttributes}, используемый для передачи
     *                           атрибутов между запросами.
     * @return перенаправление на предыдущую страницу.
     */
    @ExceptionHandler(PasswordConfirmException.class)
    public String handlePasswordConfirmException(WebRequest request, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("alert", AlertDTO.builder()
                .alertCode(AlertCode.WARNING)
                .alertMessage(AlertMessage.PASSWORD_CONFIRM)
                .build());

        return "redirect:" + request.getHeader("referer");
    }
}
