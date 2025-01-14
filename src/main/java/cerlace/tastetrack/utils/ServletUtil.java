package cerlace.tastetrack.utils;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.dto.UserDetailsDTO;
import cerlace.tastetrack.enums.Activity;
import cerlace.tastetrack.enums.Gender;
import cerlace.tastetrack.enums.Goal;
import cerlace.tastetrack.enums.MealTime;
import cerlace.tastetrack.enums.ProductType;
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
     * Создает объект типа {@code DishIngredientDTO}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     *
     * @param req объект HttpServletRequest
     * @return объект типа {@code DishIngredientDTO}
     */
    public static DishIngredientDTO mapDishIngredient(HttpServletRequest req) {
        return DishIngredientDTO.builder()
                .dish(DishDTO.builder()
                        .id(getLongParam(req, ServletConstants.DISH_ID_PARAM))
                        .build())
                .ingredient(IngredientDTO.builder()
                        .id(getLongParam(req, ServletConstants.INGREDIENT_ID_PARAM))
                        .build())
                .amount(getFloatParam(req, ServletConstants.DISH_INGREDIENT_AMOUNT_PARAM))
                .build();
    }
    /**
     * Создает объект типа {@code MealDTO}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     *
     * @param req объект HttpServletRequest
     * @return объект типа {@code MealDTO}
     */
    public static MealDTO mapMeal(HttpServletRequest req) {
        return MealDTO.builder()
                .date(getDateParam(req, ServletConstants.MEAL_DATE_PARAM))
                .mealTime(MealTime.valueOf(getStringParam(req, ServletConstants.MEAL_TIME_PARAM)))
                .build();
    }
    /**
     * Создает объект типа {@code DishDTO}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     *
     * @param req объект HttpServletRequest
     * @return объект типа {@code DishDTO}
     */
    public static DishDTO mapDish(HttpServletRequest req) {
        return DishDTO.builder()
                .name(getStringParam(req, ServletConstants.DISH_NAME_PARAM))
                .calories(getFloatParam(req, ServletConstants.DISH_CALORIES_PARAM))
                .proteins(getFloatParam(req, ServletConstants.DISH_PROTEINS_PARAM))
                .fats(getFloatParam(req, ServletConstants.DISH_FATS_PARAM))
                .carbohydrates(getFloatParam(req, ServletConstants.DISH_CARBOHYDRATES_PARAM))
                .recipe(getStringParam(req, ServletConstants.DISH_RECIPE_PARAM))
                .build();
    }

    /**
     * Создает объект типа {@code IngredientDTO}, заполняя поля значениями из параметров,
     * полученных из объекта HttpServletRequest
     *
     * @param req объект HttpServletRequest
     * @return объект типа {@code IngredientDTO}
     */
    public static IngredientDTO mapIngredient(HttpServletRequest req) {
        return IngredientDTO.builder()
                .name(getStringParam(req, ServletConstants.INGREDIENT_NAME_PARAM))
                .productType(ProductType.valueOf(
                        getStringParam(req, ServletConstants.INGREDIENT_PRODUCT_TYPE_PARAM)))
                .build();
    }

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
