<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.UserDTO" %>
<html>
<head>
    <title>Users list</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <div class="line-container">
        <h1>Users list:</h1>
        <form name="save-user"
              method="get"
              action="<%= ServletConstants.USER_SAVE_SERVLET %>">
            <button type="submit"
                    class="medium-action-button">
                Save new user
            </button>
        </form>
    </div>
    <table>
        <tr>
            <td>
                User ID
            </td>
            <td>
                Full name
            </td>
            <td>
                Birthdate
            </td>
            <td>
                Gender
            </td>
            <td>
                Email
            </td>
            <td>
                Height
            </td>
            <td>
                Weight
            </td>
            <td>
                Activity
            </td>
            <td>
                Goal
            </td>
            <td>
                User meals
            </td>
            <td colspan="2">
                Action
            </td>
        </tr>
        <% List<UserDTO> users = (List<UserDTO>) request.getAttribute(ServletConstants.USER_LIST_ATTRIBUTE);
            for (UserDTO user : users) {
        %>
        <tr>
            <td>
                <%= user.getId() %>
            </td>
            <td>
                <%= user.getFullName() %>
            </td>
            <td>
                <%= ServletConstants.DATE_FORMATTER.format(user.getBirthDate()) %>
            </td>
            <td>
                <%= user.getGender() %>
            </td>
            <td>
                <%= user.getEmail() %>
            </td>
            <td>
                <%= user.getHeight() %>
            </td>
            <td>
                <%= user.getWeight() %>
            </td>
            <td>
                <%= user.getActivity() %>
            </td>
            <td>
                <%= user.getGoal() %>
            </td>
            <td>
                <form name="list-meals"
                      method="get"
                      action="<%= ServletConstants.MEAL_LIST_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.USER_ID_PARAM %>"
                            value="<%= user.getId() %>">
                        Meals list
                    </button>
                </form>
            </td>
            <td>
                <form name="delete"
                      method="post"
                      action="<%= ServletConstants.USER_DELETE_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.USER_ID_PARAM %>"
                            value="<%= user.getId() %>">
                        Delete
                    </button>
                </form>
            </td>
            <td>
                <form name="update"
                      method="get"
                      action="<%= ServletConstants.USER_UPDATE_SERVLET %>">
                    <button type="submit"
                            class="small-action-button"
                            name="<%= ServletConstants.USER_ID_PARAM %>"
                            value="<%= user.getId() %>">
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