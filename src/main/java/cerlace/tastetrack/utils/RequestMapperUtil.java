package cerlace.tastetrack.utils;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.requestmapper.RequestMapper;
import cerlace.tastetrack.requestmapper.impl.DishIngredientRequestMapper;
import cerlace.tastetrack.requestmapper.impl.DishRequestMapper;
import cerlace.tastetrack.requestmapper.impl.IngredientRequestMapper;
import cerlace.tastetrack.requestmapper.impl.MealRequestMapper;
import cerlace.tastetrack.requestmapper.impl.UserRequestMapper;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RequestMapperUtil {

    private static final Map<Class, RequestMapper> REQUEST_MAPPER_MAP = new HashMap<>();

    static {
        REQUEST_MAPPER_MAP.put(DishIngredientDTO.class, new DishIngredientRequestMapper());
        REQUEST_MAPPER_MAP.put(DishDTO.class, new DishRequestMapper());
        REQUEST_MAPPER_MAP.put(IngredientDTO.class, new IngredientRequestMapper());
        REQUEST_MAPPER_MAP.put(MealDTO.class, new MealRequestMapper());
        REQUEST_MAPPER_MAP.put(UserDTO.class, new UserRequestMapper());
    }

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
        return (DtoT) REQUEST_MAPPER_MAP.get(clazz).getDTO(request);
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
