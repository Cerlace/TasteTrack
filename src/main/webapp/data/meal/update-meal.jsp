<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.MealDTO" %>
<%@ page import="cerlace.tastetrack.enums.MealTime" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update meal</title>
</head>
<body>
<% MealDTO meal = (MealDTO) request.getAttribute(ServletConstants.MEAL_ATTRIBUTE); %>
<h2>Update meal:</h2>
<form name="update"
      method="post"
      action="<%= ServletConstants.MEAL_UPDATE_SERVLET %>">
    <input name="<%= ServletConstants.MEAL_ID_PARAM %>"
           type="hidden"
           value="<%= meal.getId() %>"
           required>
    <input name="<%= ServletConstants.USER_ID_PARAM %>"
           type="hidden"
           value="<%= meal.getUser().getId() %>"
           required>
    <label>
        Fill meal date:
        <input name="<%= ServletConstants.MEAL_DATE_PARAM %>"
               type="date"
               value="<%= ServletConstants.DATE_FORMATTER.format(meal.getDate()) %>"
               required>
    </label><br/>
    Select meal time:<br>
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
    </label><br/>
    <jsp:include page="<%= ServletConstants.DISH_SELECT_SERVLET %>"/>
    <br/>
    <button>Send</button>
</form>
<br/>
<form name="list-meals"
      method="get"
      action="<%= ServletConstants.MEAL_LIST_SERVLET %>">
    <button name="<%= ServletConstants.USER_ID_PARAM %>"
            value="<%= meal.getUser().getId() %>">
        <h1>RETURN TO MEAL LIST</h1>
    </button>
</form>
<br/>
</body>
</html>