<%@ page import="cerlace.tastetrack.dto.UserDTO" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.Gender" %>
<%@ page import="cerlace.tastetrack.enums.Activity" %>
<%@ page import="cerlace.tastetrack.enums.Goal" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update user</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <% UserDTO user = (UserDTO) request.getAttribute(ServletConstants.USER_ATTRIBUTE); %>
    <form name="update"
          method="post"
          action="<%= ServletConstants.USER_UPDATE_SERVLET %>">
        <h2>Update user:</h2>
        <input name="<%= ServletConstants.USER_ID_PARAM %>"
               type="hidden"
               value="<%= user.getId() %>"
               required>
        <div class="input-group">
            <label for="name-input">
                Fill user full name:
            </label>
            <input id="name-input"
                   name="<%= ServletConstants.USER_FULL_NAME_PARAM %>"
                   type="text"
                   value="<%= user.getFullName() %>"
                   required>
        </div>
        <div class="input-group">
            <label for="email-input">
                Fill user email:
            </label>
            <input id="email-input"
                   name="<%= ServletConstants.USER_EMAIL_PARAM %>"
                   type="email"
                   value="<%= user.getEmail() %>"
                   required>
        </div>
        <div class="input-group">
            <label for="birthdate-input">
                Fill user birthdate:
            </label>
            <input id="birthdate-input"
                   name="<%= ServletConstants.USER_BIRTHDATE_PARAM %>"
                   type="date"
                   value="<%= ServletConstants.DATE_FORMATTER.format(user.getBirthDate()) %>"
                   required>
        </div>
        <div class="input-group">
            Select gender:
            <label>
                <input name="<%= ServletConstants.USER_GENDER_PARAM %>"
                       type="radio"
                       value="<%= Gender.MALE %>"
                       required
                    <%= user.getGender() == Gender.MALE ? "checked" : "" %>>
                Male
            </label>
            <label>
                <input name="<%= ServletConstants.USER_GENDER_PARAM %>"
                       type="radio"
                       value="<%= Gender.FEMALE %>"
                    <%= user.getGender() == Gender.FEMALE ? "checked" : "" %>>
                Female
            </label>
        </div>
        <div class="input-group">
            <label for="height-input">
                Fill user height:
            </label>
            <input id="height-input"
                   name="<%= ServletConstants.USER_HEIGHT_PARAM %>"
                   type="number"
                   step="0.1"
                   value="<%= user.getHeight() %>"
                   required>
        </div>
        <div class="input-group">
            <label for="weight-input">
                Fill user weight:
            </label>
            <input id="weight-input"
                   name="<%= ServletConstants.USER_WEIGHT_PARAM %>"
                   type="number"
                   step="0.1"
                   value="<%= user.getWeight() %>"
                   required>
        </div>
        <div class="input-group">
            Select user activity level:
            <label>
                <input name="<%= ServletConstants.USER_ACTIVITY_PARAM %>"
                       type="radio"
                       value="<%= Activity.LOW %>"
                       required
                    <%= user.getActivity() == Activity.LOW ? "checked" : "" %>>
                Low
            </label>
            <label>
                <input name="<%= ServletConstants.USER_ACTIVITY_PARAM %>"
                       type="radio"
                       value="<%= Activity.AVERAGE %>"
                    <%= user.getActivity() == Activity.AVERAGE ? "checked" : "" %>>
                Average
            </label>
            <label>
                <input name="<%= ServletConstants.USER_ACTIVITY_PARAM %>"
                       type="radio"
                       value="<%= Activity.HIGH %>"
                    <%= user.getActivity() == Activity.HIGH ? "checked" : "" %>>
                High
            </label>
        </div>
        <div class="input-group">
            Select user goal:
            <label>
                <input name="<%= ServletConstants.USER_GOAL_PARAM %>"
                       type="radio"
                       value="<%= Goal.LOSE_WEIGHT %>"
                       required
                    <%= user.getGoal() == Goal.LOSE_WEIGHT ? "checked" : "" %>>
                Lose weight
            </label>
            <label>
                <input name="<%= ServletConstants.USER_GOAL_PARAM %>"
                       type="radio"
                       value="<%= Goal.KEEP_WEIGHT %>"
                    <%= user.getGoal() == Goal.KEEP_WEIGHT ? "checked" : "" %>>
                Keep weight
            </label>
            <label>
                <input name="<%= ServletConstants.USER_GOAL_PARAM %>"
                       type="radio"
                       value="<%= Goal.GAIN_WEIGHT %>"
                    <%= user.getGoal() == Goal.GAIN_WEIGHT ? "checked" : "" %>>
                Gain weight
            </label>
        </div>
        <button type="submit"
                class="medium-action-button">
            Send
        </button>
    </form>
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