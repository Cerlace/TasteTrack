<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.Gender" %>
<%@ page import="cerlace.tastetrack.enums.Activity" %>
<%@ page import="cerlace.tastetrack.enums.Goal" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save user</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <form name="save"
          method="post"
          action="<%= ServletConstants.USER_SAVE_SERVLET %>">
        <h2>Save user:</h2>
        <div class="input-group">
            <label for="name-input">
                Fill user full name:
            </label>
            <input id="name-input"
                   name="<%= ServletConstants.USER_FULL_NAME_PARAM %>"
                   type="text"
                   required>
        </div>
        <div class="input-group">
            <label for="email-input">
                Fill user email:
            </label>
            <input id="email-input"
                   name="<%= ServletConstants.USER_EMAIL_PARAM %>"
                   type="email"
                   required>
        </div>
        <div class="input-group">
            <label for="birthdate-input">
                Fill user birthdate:
            </label>
            <input id="birthdate-input"
                   name="<%= ServletConstants.USER_BIRTHDATE_PARAM %>"
                   type="date"
                   required>
        </div>
        <div class="input-group">
            Select gender:
            <label>
                <input name="<%= ServletConstants.USER_GENDER_PARAM %>"
                       type="radio"
                       value="<%= Gender.MALE %>"
                       required>
                Male
            </label>
            <label>
                <input name="<%= ServletConstants.USER_GENDER_PARAM %>"
                       type="radio"
                       value="<%= Gender.FEMALE %>">
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
                   required>
        </div>
        <div class="input-group">
            Select user activity level:
            <label>
                <input name="<%= ServletConstants.USER_ACTIVITY_PARAM %>"
                       type="radio"
                       value="<%= Activity.LOW %>"
                       required>
                Low
            </label>
            <label>
                <input name="<%= ServletConstants.USER_ACTIVITY_PARAM %>"
                       type="radio"
                       value="<%= Activity.AVERAGE %>">
                Average
            </label>
            <label>
                <input name="<%= ServletConstants.USER_ACTIVITY_PARAM %>"
                       type="radio"
                       value="<%= Activity.HIGH %>">
                High
            </label>
        </div>
        <div class="input-group">
            Select user goal:
            <label>
                <input name="<%= ServletConstants.USER_GOAL_PARAM %>"
                       type="radio"
                       value="<%= Goal.LOSE_WEIGHT %>"
                       required>
                Lose weight
            </label>
            <label>
                <input name="<%= ServletConstants.USER_GOAL_PARAM %>"
                       type="radio"
                       value="<%= Goal.KEEP_WEIGHT %>">
                Keep weight
            </label>
            <label>
                <input name="<%= ServletConstants.USER_GOAL_PARAM %>"
                       type="radio"
                       value="<%= Goal.GAIN_WEIGHT %>">
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