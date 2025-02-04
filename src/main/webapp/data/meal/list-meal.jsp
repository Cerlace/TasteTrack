<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.MealDTO" %>
<html>
<head>
    <title>Meals list</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<jsp:include page="${ServletConstants.ALERT_BLOCK_JSP}"/>
<div class="content">
    <div class="line-container">
        <h1>Meals list:</h1>
        <form name="save"
              method="get"
              action="<%= ServletConstants.MEAL_SAVE_SERVLET %>">
            <button type="submit"
                    class="medium-action-button"
                    name="<%= ServletConstants.USER_ID_PARAM %>"
                    value="<%= request.getParameter(ServletConstants.USER_ID_PARAM) %>">
                Save new meal
            </button>
        </form>
    </div>
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
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.MEAL_ID_PARAM %>"
                            value="<%= meal.getId() %>">
                        Delete
                    </button>
                </form>
            </td>
            <td>
                <form name="update"
                      method="get"
                      action="<%= ServletConstants.MEAL_UPDATE_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.MEAL_ID_PARAM %>"
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
    <form name="list-users"
          method="get"
          action="<%= ServletConstants.USER_LIST_SERVLET %>">
        <button type="submit"
                class="medium-action-button">
            Return to users
        </button>
    </form>
</div>
</body>
</html>