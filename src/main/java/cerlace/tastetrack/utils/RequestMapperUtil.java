package cerlace.tastetrack.utils;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

public class RequestMapperUtil {

    /**
     * Создает объект типа {@code DtoT}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     *
     * @param request объект HttpServletRequest
     * @param clazz   класс объекта DTO
     * @param <DtoT>  тип DTO, возвращаемый методом
     * @return объект типа {@code DtoT}
     */
    public static <DtoT> DtoT getDTO(HttpServletRequest request, Class<DtoT> clazz) {
        return RequestMapperFactory.getMapper(clazz).getDTO(request);
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
