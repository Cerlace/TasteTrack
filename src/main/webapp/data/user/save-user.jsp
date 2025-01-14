<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.Gender" %>
<%@ page import="cerlace.tastetrack.enums.Activity" %>
<%@ page import="cerlace.tastetrack.enums.Goal" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save user</title>
</head>
<body>
<h2>Save user:</h2>
<form name="save"
      method="post"
      action="<%= ServletConstants.USER_SAVE_SERVLET %>">
    <label>
        Fill user full name:
        <input name="<%= ServletConstants.USER_FULL_NAME_PARAM %>" type="text" required>
    </label><br/>
    <label>
        Fill user email:
        <input name="<%= ServletConstants.USER_EMAIL_PARAM %>" type="email" required>
    </label><br/>
    <label>
        Fill user birthdate:
        <input name="<%= ServletConstants.USER_BIRTHDATE_PARAM %>" type="date" required>
    </label><br/>
    Select gender:<br>
    <label>
        <input name="<%= ServletConstants.USER_GENDER_PARAM %>" type="radio" value="<%= Gender.MALE %>" required>
        Male
    </label>
    <label>
        <input name="<%= ServletConstants.USER_GENDER_PARAM %>" type="radio" value="<%= Gender.FEMALE %>">
        Female
    </label><br/>
    <label>
        Fill user height:
        <input name="<%= ServletConstants.USER_HEIGHT_PARAM %>"
               type="number"
               step="0.1"
               required>
    </label><br/>
    <label>
        Fill user weight:
        <input name="<%= ServletConstants.USER_WEIGHT_PARAM %>"
               type="number"
               step="0.1"
               required>
    </label><br/>
    Select user activity level:<br>
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
    </label><br/>
    Select user goal:<br>
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
    </label><br/>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.USER_LIST_SERVLET %>>
    <button><h1>RETURN TO USER LIST</h1></button>
</a><br/>
</body>
</html>