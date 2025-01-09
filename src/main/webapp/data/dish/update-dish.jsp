<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.DishDTO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update dish</title>
</head>
<body>
<% DishDTO dish = (DishDTO) request.getAttribute(ServletConstants.DISH_ATTRIBUTE); %>
<h2>Update dish:</h2>
<form name="update"
      method="post"
      action="<%= ServletConstants.DISH_UPDATE_SERVLET %>">
    <input name="<%= ServletConstants.DISH_ID_PARAM %>"
           type="hidden"
           value="<%= dish.getId() %>"
           required>
    <label>
        Fill new dish name:
        <input name="<%= ServletConstants.DISH_NAME_PARAM %>"
               type="text"
               value="<%= dish.getName() %>"
               required>
    </label><br/>
    <label>
        Fill new calories amount:
        <input name="<%= ServletConstants.DISH_CALORIES_PARAM %>"
               type="number"
               step="0.1"
               value="<%= dish.getCalories() %>"
               required>
    </label><br/>
    <label>
        Fill new proteins amount:
        <input name="<%= ServletConstants.DISH_PROTEINS_PARAM %>"
               type="number"
               step="0.1"
               value="<%= dish.getProteins() %>"
               required>
    </label><br/>
    <label>
        Fill new fats amount:
        <input name="<%= ServletConstants.DISH_FATS_PARAM %>"
               type="number"
               step="0.1"
               value="<%= dish.getFats() %>"
               required>
    </label><br/>
    <label>
        Fill new carbohydrates amount:
        <input name="<%= ServletConstants.DISH_CARBOHYDRATES_PARAM %>"
               type="number"
               step="0.1"
               value="<%= dish.getCarbohydrates() %>"
               required>
    </label><br/>
    <label>
        Fill new dish recipe:
        <input name="<%= ServletConstants.DISH_RECIPE_PARAM %>"
               type="text"
               value="<%= dish.getRecipe() %>"
               required>
    </label><br/>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.DISH_LIST_SERVLET %>>
    <button><h1>RETURN TO DISH LIST</h1></button>
</a><br/>
</body>
</html>