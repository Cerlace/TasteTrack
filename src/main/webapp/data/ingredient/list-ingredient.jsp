<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.IngredientDTO" %>
<html>
<head>
    <title>Ingredients list</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/table.css'>
</head>
<body>

<a href="<%= ServletConstants.INGREDIENT_SAVE_SERVLET %>">
    <button><h1>SAVE INGREDIENT</h1></button>
</a><br/>
<br/>
<h1>Ingredients list:</h1>
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
                <button name="<%= ServletConstants.INGREDIENT_ID_PARAM %>"
                        value="<%= ingredient.getId() %>">
                    Delete
                </button>
            </form>
        </td>
        <td>
            <form name="update"
                  method="get"
                  action="<%= ServletConstants.INGREDIENT_UPDATE_SERVLET %>">
                <button name="<%= ServletConstants.INGREDIENT_ID_PARAM %>"
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
<br/>
<a href=<%= ServletConstants.ADMIN_PAGE_SERVLET %>>
    <button><h1>RETURN TO ADMIN PAGE</h1></button>
</a><br/>
</body>
</html>