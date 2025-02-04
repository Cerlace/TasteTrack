<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.DishDTO" %>
<html>
<head>
    <title>Dishes list</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<jsp:include page="${ServletConstants.ALERT_BLOCK_JSP}"/>
<div class="content">
    <div class="line-container">
        <h1>Dishes list:</h1>
        <form name="save-dish"
              method="get"
              action="<%= ServletConstants.DISH_SAVE_SERVLET %>">
            <button type="submit"
                    class="medium-action-button">
                Save new dish
            </button>
        </form>
    </div>
    <table>
        <tr>
            <td>
                Dish ID
            </td>
            <td>
                Dish name
            </td>
            <td>
                Dish ingredients
            </td>
            <td>
                Calories
            </td>
            <td>
                Proteins
            </td>
            <td>
                Fats
            </td>
            <td>
                Carbohydrates
            </td>
            <td>
                Recipe
            </td>
            <td colspan="2">
                Action
            </td>
        </tr>
        <% List<DishDTO> dishes = (List<DishDTO>) request.getAttribute(ServletConstants.DISH_LIST_ATTRIBUTE);
            for (DishDTO dish : dishes) {
        %>
        <tr>
            <td>
                <%= dish.getId() %>
            </td>
            <td>
                <%= dish.getName() %>
            </td>
            <td>
                <form name="list-dish-ingredients"
                      method="get"
                      action="<%= ServletConstants.DISH_INGREDIENT_LIST_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.DISH_ID_PARAM %>"
                            value="<%= dish.getId() %>">
                        Ingredient list
                    </button>
                </form>
            </td>
            <td>
                <%= dish.getCalories() %>
            </td>
            <td>
                <%= dish.getProteins() %>
            </td>
            <td>
                <%= dish.getFats() %>
            </td>
            <td>
                <%= dish.getCarbohydrates() %>
            </td>
            <td>
                <%= dish.getRecipe() %>
            </td>
            <td>
                <form name="delete"
                      method="post"
                      action="<%= ServletConstants.DISH_DELETE_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.DISH_ID_PARAM %>"
                            value="<%= dish.getId() %>">
                        Delete
                    </button>
                </form>
            </td>
            <td>
                <form name="update"
                      method="get"
                      action="<%= ServletConstants.DISH_UPDATE_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.DISH_ID_PARAM %>"
                            value="<%= dish.getId() %>">
                        Update
                    </button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>
</div>
</body>
</html>