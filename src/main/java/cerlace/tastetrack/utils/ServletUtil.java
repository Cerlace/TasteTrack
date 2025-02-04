package cerlace.tastetrack.utils;

import cerlace.tastetrack.enums.AlertCode;
import cerlace.tastetrack.exceptions.ConstraintViolationAppException;
import cerlace.tastetrack.servlet.ServletConstants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.function.Supplier;

public class ServletUtil {

    public static final String UK_CONSTRAINT_VIOLATION_MESSAGE =
            "UK constraint violation! Cannot add or update row";
    public static final String FK_CONSTRAINT_VIOLATION_PARENT_MESSAGE =
            "FK constraint violation! Cannot delete or update a parent row";
    public static final String FK_CONSTRAINT_VIOLATION_CHILD_MESSAGE =
            "FK constraint violation! Cannot add or update a child row";
    public static final String UNKNOWN_CONSTRAINT_VIOLATION_MESSAGE =
            "Unknown constraint violation!";

    /**
     * Метод для обработки ошибок Hibernate, и преобразования их в бизнес ошибки.
     *
     * @param servletExecutor функциональный интерфейс,
     *                        который выполняет метод сервиса
     * @param <T>             тип возвращаемого значения
     * @param request         объект HttpServletRequest
     * @return результат выполнения метода интерфейса ServiceExecutor
     */
    public static <T> T handleAppExceptions(HttpServletRequest request, Supplier<T> servletExecutor) {
        try {
            return servletExecutor.get();
        } catch (ConstraintViolationAppException e) {
            switch (e.getConstraintType()) {
                case UNIQUE:
                    ServletUtil.setAlertAttributes(request, AlertCode.WARNING,
                            UK_CONSTRAINT_VIOLATION_MESSAGE);
                    break;
                case FOREIGN_KEY_PARENT:
                    ServletUtil.setAlertAttributes(request, AlertCode.WARNING,
                            FK_CONSTRAINT_VIOLATION_PARENT_MESSAGE);
                    break;
                case FOREIGN_KEY_CHILD:
                    ServletUtil.setAlertAttributes(request, AlertCode.WARNING,
                            FK_CONSTRAINT_VIOLATION_CHILD_MESSAGE);
                    break;
                case UNKNOWN:
                    ServletUtil.setAlertAttributes(request, AlertCode.WARNING,
                            UNKNOWN_CONSTRAINT_VIOLATION_MESSAGE);
                    break;
            }
            return null;
        }
    }

    /**
     * Устанавливает атрибуты для уведомлений в сессию
     *
     * @param request      объект HttpServletRequest
     * @param alertCode    код уведомления
     * @param alertMessage сообщение для уведомления
     */
    public static void setAlertAttributes(HttpServletRequest request, AlertCode alertCode, String alertMessage) {
        HttpSession session = request.getSession();
        session.setAttribute(ServletConstants.ALERT_TYPE_ATTRIBUTE, alertCode.name());
        session.setAttribute(ServletConstants.ALERT_MESSAGE_ATTRIBUTE, alertMessage);
    }
}
