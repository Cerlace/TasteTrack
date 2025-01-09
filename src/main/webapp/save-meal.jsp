<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.MealTime" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save meal</title>
</head>
<body>
<h2>Save meal:</h2>
<form name="save"
      method="post"
      action="<%= ServletConstants.MEAL_SAVE_SERVLET %>">
    <label>
        Fill meal date:
        <input name="<%= ServletConstants.MEAL_DATE_PARAM %>" type="date" required>
    </label><br/>
    Select meal time:<br>
    <label>
        <input name="<%= ServletConstants.MEAL_TIME_PARAM %>" type="radio" value="<%= MealTime.BREAKFAST %>" required>
        Breakfast
    </label>
    <label>
        <input name="<%= ServletConstants.MEAL_TIME_PARAM %>" type="radio" value="<%= MealTime.LUNCH %>">
        Lunch
    </label>
    <label>
        <input name="<%= ServletConstants.MEAL_TIME_PARAM %>" type="radio" value="<%= MealTime.DINNER %>">
        Dinner
    </label><br/>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.MEAL_LIST_SERVLET %>>
    <button><h1>RETURN TO MEAL LIST</h1></button>
</a><br/>
</body>
</html>