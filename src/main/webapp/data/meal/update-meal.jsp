<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.MealDTO" %>
<%@ page import="cerlace.tastetrack.enums.MealTime" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update meal</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <% MealDTO meal = (MealDTO) request.getAttribute(ServletConstants.MEAL_ATTRIBUTE); %>
    <form name="update"
          method="post"
          action="<%= ServletConstants.MEAL_UPDATE_SERVLET %>">
        <h2>Update meal:</h2>
        <input name="<%= ServletConstants.MEAL_ID_PARAM %>"
               type="hidden"
               value="<%= meal.getId() %>"
               required>
        <input name="<%= ServletConstants.USER_ID_PARAM %>"
               type="hidden"
               value="<%= meal.getUser().getId() %>"
               required>
        <div class="input-group">
            <label for="date-input">
                Fill meal date:
            </label>
            <input id="date-input"
                   name="<%= ServletConstants.MEAL_DATE_PARAM %>"
                   type="date"
                   value="<%= ServletConstants.DATE_FORMATTER.format(meal.getDate()) %>"
                   required>
        </div>
        <div class="input-group">
            Select meal time:
            <label>
                <input name="<%= ServletConstants.MEAL_TIME_PARAM %>"
                       type="radio"
                       value="<%= MealTime.BREAKFAST %>"
                    <%= meal.getMealTime() == MealTime.BREAKFAST ? "checked" : "" %>
                       required>
                Breakfast
            </label>
            <label>
                <input name="<%= ServletConstants.MEAL_TIME_PARAM %>"
                       type="radio"
                       value="<%= MealTime.LUNCH %>"
                    <%= meal.getMealTime() == MealTime.LUNCH ? "checked" : "" %>>
                Lunch
            </label>
            <label>
                <input name="<%= ServletConstants.MEAL_TIME_PARAM %>"
                       type="radio"
                       value="<%= MealTime.DINNER %>"
                    <%= meal.getMealTime() == MealTime.DINNER ? "checked" : "" %>>
                Dinner
            </label>
        </div>

        <jsp:include page="<%= ServletConstants.DISH_SELECT_SERVLET %>"/>

        <button type="submit"
                class="medium-action-button">
            Send
        </button>
    </form>
    <form name="list-meals"
          method="get"
          action="<%= ServletConstants.MEAL_LIST_SERVLET %>">
        <button type="submit"
                class="medium-action-button"
                name="<%= ServletConstants.USER_ID_PARAM %>"
                value="<%= request.getParameter(ServletConstants.USER_ID_PARAM) %>">
            Return to meals
        </button>
    </form>
</div>
</body>
</html>