package cerlace.tastetrack.servlet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class ServletConstants {
    public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd");

    public static final String ADMIN_PAGE_JSP = "/admin-page.jsp";
    public static final String ADMIN_PAGE_SERVLET = "admin-page";

    public static final String USER_LIST_JSP = "/list-user.jsp";
    public static final String USER_SAVE_JSP = "/save-user.jsp";
    public static final String USER_UPDATE_JSP = "/update-user.jsp";
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

    public static final String USER_DETAILS_LIST_JSP = "/list-user-details.jsp";
    public static final String USER_DETAILS_SAVE_JSP = "/save-user-details.jsp";
    public static final String USER_DETAILS_UPDATE_JSP = "/update-user-details.jsp";
    public static final String USER_DETAILS_LIST_SERVLET = "list-user-details";
    public static final String USER_DETAILS_SAVE_SERVLET = "save-user-details";
    public static final String USER_DETAILS_UPDATE_SERVLET = "update-user-details";
    public static final String USER_DETAILS_DELETE_SERVLET = "delete-user-details";

    public static final String USER_DETAILS_LIST_ATTRIBUTE = "userDetailsList";
    public static final String USER_DETAILS_ATTRIBUTE = "userDetailsObject";
    public static final String USER_DETAILS_ID_PARAM = "userDetailsId";
    public static final String USER_DETAILS_HEIGHT_PARAM = "userDetailsHeight";
    public static final String USER_DETAILS_WEIGHT_PARAM = "userDetailsWeight";
    public static final String USER_DETAILS_ACTIVITY_PARAM = "userDetailsActivity";
    public static final String USER_DETAILS_GOAL_PARAM = "userDetailsGoal";
}
