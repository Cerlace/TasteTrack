<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.UserDetailsDTO" %>
<html>
<head>
    <title>User details list</title>
    <link rel='stylesheet' type='text/css' media='screen' href='table.css'>
</head>
<body>

<a href="<%= ServletConstants.USER_DETAILS_SAVE_SERVLET %>">
    <button><h1>SAVE USER DETAILS PAGE</h1></button>
</a><br/>
<br/>
<h1>User details list:</h1>
<table>
    <tr>
        <td>
            User details ID
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
        <td colspan="2">
            Action
        </td>
    </tr>
    <% List<UserDetailsDTO> userDetailsList = (List<UserDetailsDTO>) request.getAttribute(ServletConstants.USER_DETAILS_LIST_ATTRIBUTE);
        for (UserDetailsDTO userDetails : userDetailsList) {
    %>
    <tr>
        <td>
            <%= userDetails.getId() %>
        </td>
        <td>
            <%= userDetails.getHeight() %>
        </td>
        <td>
            <%= userDetails.getWeight() %>
        </td>
        <td>
            <%= userDetails.getActivity() %>
        </td>
        <td>
            <%= userDetails.getGoal() %>
        </td>
        <td>
            <form name="delete"
                  method="post"
                  action="<%= ServletConstants.USER_DETAILS_DELETE_SERVLET %>">
                <button name="<%= ServletConstants.USER_DETAILS_ID_PARAM %>"
                        value="<%= userDetails.getId() %>">
                    Delete
                </button>
            </form>
        </td>
        <td>
            <form name="update"
                  method="get"
                  action="<%= ServletConstants.USER_DETAILS_UPDATE_SERVLET %>">
                <button name="<%= ServletConstants.USER_DETAILS_ID_PARAM %>"
                        value="<%= userDetails.getId() %>">
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