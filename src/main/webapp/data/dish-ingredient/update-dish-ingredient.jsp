<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.DishIngredientDTO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update dish ingredient</title>
</head>
<body>
<% DishIngredientDTO dishIngredient = (DishIngredientDTO) request.getAttribute(ServletConstants.DISH_INGREDIENT_ATTRIBUTE); %>
<h2>Update dish ingredient:</h2>
<form name="update"
      method="post"
      action="<%= ServletConstants.DISH_INGREDIENT_UPDATE_SERVLET %>">
    <input name="<%= ServletConstants.DISH_INGREDIENT_ID_PARAM %>"
           type="hidden"
           value="<%= dishIngredient.getId() %>"
           required>
    <input name="<%= ServletConstants.DISH_ID_PARAM %>"
           type="hidden"
           value="<%= dishIngredient.getDish().getId() %>"
           required>
    <jsp:include page="<%= ServletConstants.INGREDIENT_SELECT_SERVLET %>"/>
    <br/>
    <label>
        Fill new amount:
        <input name="<%= ServletConstants.DISH_INGREDIENT_AMOUNT_PARAM %>"
               type="number"
               step="0.1"
               value="<%= dishIngredient.getAmount() %>"
               required>
    </label><br/>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.DISH_INGREDIENT_LIST_SERVLET %>>
    <button><h1>RETURN TO DISH INGREDIENT LIST</h1></button>
</a><br/>
</body>
</html>