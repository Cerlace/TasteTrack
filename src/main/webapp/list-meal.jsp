<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.MealDTO" %>
<html>
<head>
    <title>Meals list</title>
    <link rel='stylesheet' type='text/css' media='screen' href='table.css'>
</head>
<body>

<a href="<%= ServletConstants.MEAL_SAVE_SERVLET %>">
    <button><h1>SAVE MEAL</h1></button>
</a><br/>
<br/>
<h1>Meals list:</h1>
<table>
    <tr>
        <td>
            Meal ID
        </td>
        <td>
            Meal date
        </td>
        <td>
            Meal time
        </td>
        <td colspan="2">
            Action
        </td>
    </tr>
    <% List<MealDTO> meals = (List<MealDTO>) request.getAttribute(ServletConstants.MEAL_LIST_ATTRIBUTE);
        for (MealDTO meal : meals) {
    %>
    <tr>
        <td>
            <%= meal.getId() %>
        </td>
        <td>
            <%= ServletConstants.DATE_FORMATTER.format(meal.getDate()) %>
        </td>
        <td>
            <%= meal.getMealTime() %>
        </td>
        <td>
            <form name="delete"
                  method="post"
                  action="<%= ServletConstants.MEAL_DELETE_SERVLET %>">
                <button name="<%= ServletConstants.MEAL_ID_PARAM %>"
                        value="<%= meal.getId() %>">
                    Delete
                </button>
            </form>
        </td>
        <td>
            <form name="update"
                  method="get"
                  action="<%= ServletConstants.MEAL_UPDATE_SERVLET %>">
                <button name="<%= ServletConstants.MEAL_ID_PARAM %>"
                        value="<%= meal.getId() %>">
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