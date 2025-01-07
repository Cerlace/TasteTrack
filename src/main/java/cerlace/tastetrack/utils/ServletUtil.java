package cerlace.tastetrack.utils;

import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.dto.UserDetailsDTO;
import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Gender;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.servlet.ServletConstants;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class ServletUtil {
    /**
     * Создает объект типа {@code UserDTO}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     *
     * @param req объект HttpServletRequest
     * @return объект типа {@code UserDTO}
     */
    public static UserDTO mapUser(HttpServletRequest req) {
        return UserDTO.builder()
                .fullName(getStringParam(req, ServletConstants.USER_FULL_NAME_PARAM))
                .birthDate(getDateParam(req, ServletConstants.USER_BIRTHDATE_PARAM))
                .gender(Gender.valueOf(getStringParam(req, ServletConstants.USER_GENDER_PARAM)))
                .email(getStringParam(req, ServletConstants.USER_EMAIL_PARAM))
                .build();
    }

    /**
     * Создает объект типа {@code UserDetailsDTO}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     *
     * @param req объект HttpServletRequest
     * @return объект типа {@code UserDetailsDTO}
     */
    public static UserDetailsDTO mapUserDetails(HttpServletRequest req) {
        return UserDetailsDTO.builder()
                .id(getLongParam(req, ServletConstants.USER_DETAILS_ID_PARAM))
                .height(getFloatParam(req, ServletConstants.USER_DETAILS_HEIGHT_PARAM))
                .weight(getFloatParam(req, ServletConstants.USER_DETAILS_WEIGHT_PARAM))
                .activity(Activity.valueOf(
                        getStringParam(req, ServletConstants.USER_DETAILS_ACTIVITY_PARAM)))
                .goal(Goal.valueOf(
                        getStringParam(req, ServletConstants.USER_DETAILS_GOAL_PARAM)))
                .build();
    }

    /**
     * Получает из объекта HttpServletRequest параметр по его имени
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return строковое представление параметра
     */
    public static String getStringParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }

    /**
     * Получает из объекта HttpServletRequest параметр по его имени,
     * и преобразует его в тип {@code Integer}
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return представление параметра типа {@code Integer}
     */
    public static Integer getIntegerParam(HttpServletRequest req, String nameField) {
        String intStr = req.getParameter(nameField);
        return intStr != null ? Integer.parseInt(intStr) : null;
    }

    /**
     * Получает из объекта HttpServletRequest параметр по его имени,
     * и преобразует его в тип {@code Long}
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return представление параметра типа {@code Long}
     */
    public static Long getLongParam(HttpServletRequest req, String nameField) {
        String longStr = req.getParameter(nameField);
        return longStr != null ? Long.parseLong(longStr) : null;
    }

    /**
     * Получает из объекта HttpServletRequest параметр по его имени,
     * и преобразует его в тип {@code Long}
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return представление параметра типа {@code Long}
     */
    public static Float getFloatParam(HttpServletRequest req, String nameField) {
        String floatStr = req.getParameter(nameField);
        return floatStr != null ? Float.parseFloat(floatStr) : null;
    }

    /**
     * Получает из объекта HttpServletRequest параметр по его имени,
     * и преобразует его в тип {@code Date}
     *
     * @param req       объект HttpServletRequest
     * @param nameField имя параметра, который получаем из HttpServletRequest
     * @return представление параметра типа {@code Date}
     */
    public static Date getDateParam(HttpServletRequest req, String nameField) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = req.getParameter(nameField);
        try {
            return dateStr != null ? formatter.parse(dateStr) : null;
        } catch (ParseException e) {
            return null;
        }
    }
}
