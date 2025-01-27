<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.IngredientDTO" %>
<html>
<head>
    <title>Ingredients list</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <div class="line-container">
        <h1>Ingredients list:</h1>
        <form name="save-ingredient"
              method="get"
              action="<%= ServletConstants.INGREDIENT_SAVE_SERVLET %>">
            <button type="submit"
                    class="medium-action-button">
                Save new ingredient
            </button>
        </form>
    </div>
    <table>
        <tr>
            <td>
                Ingredient ID
            </td>
            <td>
                Name
            </td>
            <td>
                Product type
            </td>
            <td colspan="2">
                Action
            </td>
        </tr>
        <% List<IngredientDTO> ingredients = (List<IngredientDTO>) request.getAttribute(ServletConstants.INGREDIENT_LIST_ATTRIBUTE);
            for (IngredientDTO ingredient : ingredients) {
        %>
        <tr>
            <td>
                <%= ingredient.getId() %>
            </td>
            <td>
                <%= ingredient.getName() %>
            </td>
            <td>
                <%= ingredient.getProductType() %>
            </td>
            <td>
                <form name="delete"
                      method="post"
                      action="<%= ServletConstants.INGREDIENT_DELETE_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.INGREDIENT_ID_PARAM %>"
                            value="<%= ingredient.getId() %>">
                        Delete
                    </button>
                </form>
            </td>
            <td>
                <form name="update"
                      method="get"
                      action="<%= ServletConstants.INGREDIENT_UPDATE_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.INGREDIENT_ID_PARAM %>"
                            value="<%= ingredient.getId() %>">
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