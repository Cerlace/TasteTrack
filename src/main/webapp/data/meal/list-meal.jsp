<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.MealDTO" %>
<html>
<head>
    <title>Meals list</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/table.css'>
</head>
<body>
<form name="save"
      method="get"
      action="<%= ServletConstants.MEAL_SAVE_SERVLET %>">
    <button name="<%= ServletConstants.USER_ID_PARAM %>"
            value="<%= request.getParameter(ServletConstants.USER_ID_PARAM) %>">
        <h1>SAVE MEAL</h1>
    </button>
</form>
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
        <td>
            Dish name
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
            <%= meal.getDish().getName() %>
        </td>
        <td>
            <form name="delete"
                  method="post"
                  action="<%= ServletConstants.MEAL_DELETE_SERVLET %>">
                <input name="<%= ServletConstants.USER_ID_PARAM %>"
                       type="hidden"
                       value="<%= meal.getUser().getId() %>"
                       required>
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
<a href=<%= ServletConstants.USER_LIST_SERVLET %>>
    <button><h1>RETURN TO USERS LIST PAGE</h1></button>
</a><br/>
</body>
</html>