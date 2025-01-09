package cerlace.tastetrack.servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ServletConstants {
    public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    public static final String ADMIN_PAGE_JSP = "/admin-page.jsp";
    public static final String ADMIN_PAGE_SERVLET = "admin-page";

    public static final String USER_LIST_JSP = "/data/user/list-user.jsp";
    public static final String USER_SAVE_JSP = "/data/user/save-user.jsp";
    public static final String USER_UPDATE_JSP = "/data/user/update-user.jsp";
    public static final String USER_LIST_SERVLET = "list-user";
    public static final String USER_SAVE_SERVLET = "save-user";
    public static final String USER_UPDATE_SERVLET = "update-user";
    public static final String USER_DELETE_SERVLET = "delete-user";

    public static final String USER_LIST_ATTRIBUTE = "userList";
    public static final String USER_ATTRIBUTE = "userObject";
    public static final String USER_ID_PARAM = "userId";
    public static final String USER_FULL_NAME_PARAM = "userFullName";
    public static final String USER_BIRTHDATE_PARAM = "userBirthDate";
    public static final String USER_GENDER_PARAM = "userGender";
    public static final String USER_EMAIL_PARAM = "userEmail";

    public static final String USER_DETAILS_LIST_JSP = "/data/user-details/list-user-details.jsp";
    public static final String USER_DETAILS_UPDATE_JSP = "/data/user-details/update-user-details.jsp";
    public static final String USER_DETAILS_LIST_SERVLET = "list-user-details";
    public static final String USER_DETAILS_UPDATE_SERVLET = "update-user-details";

    public static final String USER_DETAILS_LIST_ATTRIBUTE = "userDetailsList";
    public static final String USER_DETAILS_ATTRIBUTE = "userDetailsObject";
    public static final String USER_DETAILS_ID_PARAM = "userDetailsId";
    public static final String USER_DETAILS_HEIGHT_PARAM = "userDetailsHeight";
    public static final String USER_DETAILS_WEIGHT_PARAM = "userDetailsWeight";
    public static final String USER_DETAILS_ACTIVITY_PARAM = "userDetailsActivity";
    public static final String USER_DETAILS_GOAL_PARAM = "userDetailsGoal";

    public static final String INGREDIENT_LIST_JSP = "/data/ingredient/list-ingredient.jsp";
    public static final String INGREDIENT_SAVE_JSP = "/data/ingredient/save-ingredient.jsp";
    public static final String INGREDIENT_UPDATE_JSP = "/data/ingredient/update-ingredient.jsp";
    public static final String INGREDIENT_LIST_SERVLET = "list-ingredient";
    public static final String INGREDIENT_SAVE_SERVLET = "save-ingredient";
    public static final String INGREDIENT_UPDATE_SERVLET = "update-ingredient";
    public static final String INGREDIENT_DELETE_SERVLET = "delete-ingredient";

    public static final String INGREDIENT_LIST_ATTRIBUTE = "ingredientList";
    public static final String INGREDIENT_ATTRIBUTE = "ingredientObject";
    public static final String INGREDIENT_ID_PARAM = "ingredientId";
    public static final String INGREDIENT_NAME_PARAM = "ingredientName";
    public static final String INGREDIENT_PRODUCT_TYPE_PARAM = "ingredientProductType";

    public static final String DISH_LIST_JSP = "/data/dish/list-dish.jsp";
    public static final String DISH_SAVE_JSP = "/data/dish/save-dish.jsp";
    public static final String DISH_UPDATE_JSP = "/data/dish/update-dish.jsp";
    public static final String DISH_LIST_SERVLET = "list-dish";
    public static final String DISH_SAVE_SERVLET = "save-dish";
    public static final String DISH_UPDATE_SERVLET = "update-dish";
    public static final String DISH_DELETE_SERVLET = "delete-dish";

    public static final String DISH_LIST_ATTRIBUTE = "dishList";
    public static final String DISH_ATTRIBUTE = "dishObject";
    public static final String DISH_ID_PARAM = "dishId";
    public static final String DISH_NAME_PARAM = "dishName";
    public static final String DISH_CALORIES_PARAM = "dishCalories";
    public static final String DISH_PROTEINS_PARAM = "dishProteins";
    public static final String DISH_FATS_PARAM = "dishFats";
    public static final String DISH_CARBOHYDRATES_PARAM = "dishCarbohydrates";
    public static final String DISH_RECIPE_PARAM = "dishRecipe";

    public static final String MEAL_LIST_JSP = "/data/meal/list-meal.jsp";
    public static final String MEAL_SAVE_JSP = "/data/meal/save-meal.jsp";
    public static final String MEAL_UPDATE_JSP = "/data/meal/update-meal.jsp";
    public static final String MEAL_LIST_SERVLET = "list-meal";
    public static final String MEAL_SAVE_SERVLET = "save-meal";
    public static final String MEAL_UPDATE_SERVLET = "update-meal";
    public static final String MEAL_DELETE_SERVLET = "delete-meal";

    public static final String MEAL_LIST_ATTRIBUTE = "mealList";
    public static final String MEAL_ATTRIBUTE = "mealObject";
    public static final String MEAL_ID_PARAM = "mealId";
    public static final String MEAL_DATE_PARAM = "mealDate";
    public static final String MEAL_TIME_PARAM = "mealTime";
}
