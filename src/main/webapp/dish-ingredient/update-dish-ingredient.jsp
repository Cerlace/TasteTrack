<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.DishIngredientDTO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update dish ingredient</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <% DishIngredientDTO dishIngredient = (DishIngredientDTO) request.getAttribute(ServletConstants.DISH_INGREDIENT_ATTRIBUTE); %>
    <form name="update"
          method="post"
          action="<%= ServletConstants.DISH_INGREDIENT_UPDATE_SERVLET %>">
        <h2>Update dish ingredient:</h2>
        <input name="<%= ServletConstants.DISH_INGREDIENT_ID_PARAM %>"
               type="hidden"
               value="<%= dishIngredient.getId() %>"
               required>
        <input name="<%= ServletConstants.DISH_ID_PARAM %>"
               type="hidden"
               value="<%= dishIngredient.getDish().getId() %>"
               required>

        <jsp:include page="<%= ServletConstants.INGREDIENT_SELECT_SERVLET %>"/>

        <div class="input-group">
            <label for="amount-input">
                Fill amount:
            </label>
            <input id="amount-input"
                   name="<%= ServletConstants.DISH_INGREDIENT_AMOUNT_PARAM %>"
                   type="number"
                   step="0.1"
                   value="<%= dishIngredient.getAmount() %>"
                   required>
        </div>
        <button type="submit"
                class="medium-action-button">
            Send
        </button>
    </form>
    <form name="list-dish-ingredients"
          method="get"
          action="<%= ServletConstants.DISH_INGREDIENT_LIST_SERVLET %>">
        <button type="submit"
                class="medium-action-button"
                name="<%= ServletConstants.DISH_ID_PARAM %>"
                value="<%= request.getParameter(ServletConstants.DISH_ID_PARAM) %>">
            Return to dish ingredients
        </button>
    </form>
</div>
</body>
</html>