<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.DishIngredientDTO" %>
<html>
<head>
    <title>Dish ingredient list</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/table.css'>
</head>
<body>
<form name="save"
      method="get"
      action="<%= ServletConstants.DISH_INGREDIENT_SAVE_SERVLET %>">
    <button name="<%= ServletConstants.DISH_ID_PARAM %>"
            value="<%= request.getParameter(ServletConstants.DISH_ID_PARAM) %>">
        <h1>SAVE DISH INGREDIENT</h1>
    </button>
</form>
<br/>
<h1>Dish ingredient list:</h1>
<table>
    <tr>
        <td>
            Dish ingredient ID
        </td>
        <td>
            Ingredient name
        </td>
        <td>
            Amount (grams or count)
        </td>
        <td colspan="2">
            Action
        </td>
    </tr>
    <% List<DishIngredientDTO> dishIngredients = (List<DishIngredientDTO>) request.getAttribute(
            ServletConstants.DISH_INGREDIENT_LIST_ATTRIBUTE);
        for (DishIngredientDTO dishIngredient : dishIngredients) {
    %>
    <tr>
        <td>
            <%= dishIngredient.getId() %>
        </td>
        <td>
            <%= dishIngredient.getIngredient().getName() %>
        </td>
        <td>
            <%= dishIngredient.getAmount() %>
        </td>
        <td>
            <form name="delete"
                  method="post"
                  action="<%= ServletConstants.DISH_INGREDIENT_DELETE_SERVLET %>">
                <input name="<%= ServletConstants.DISH_ID_PARAM %>"
                       type="hidden"
                       value="<%= dishIngredient.getDish().getId() %>"
                       required>
                <button name="<%= ServletConstants.DISH_INGREDIENT_ID_PARAM %>"
                        value="<%= dishIngredient.getId() %>">
                    Delete
                </button>
            </form>
        </td>
        <td>
            <form name="update"
                  method="get"
                  action="<%= ServletConstants.DISH_INGREDIENT_UPDATE_SERVLET %>">
                <button name="<%= ServletConstants.DISH_INGREDIENT_ID_PARAM %>"
                        value="<%= dishIngredient.getId() %>">
                    Update
                </button>
            </form>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br/>
<a href=<%= ServletConstants.DISH_LIST_SERVLET %>>
    <button><h1>RETURN TO DISH LIST PAGE</h1></button>
</a><br/>
</body>
</html>