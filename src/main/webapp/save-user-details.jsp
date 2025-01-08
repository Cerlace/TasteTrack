<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.Activity" %>
<%@ page import="cerlace.tastetrack.enums.Goal" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save user details</title>
</head>
<body>
<h2>Save user details:</h2>
<form name="save"
      method="post"
      action="<%= ServletConstants.USER_DETAILS_SAVE_SERVLET %>">
    <label>
        Fill user id:
        <input name="<%= ServletConstants.USER_DETAILS_ID_PARAM %>"
               type="number"
               required>
    </label><br/>
    <label>
        Fill user height:
        <input name="<%= ServletConstants.USER_DETAILS_HEIGHT_PARAM %>"
               type="number" step="0.1" required>
    </label><br/>
    <label>
        Fill user weight:
        <input name="<%= ServletConstants.USER_DETAILS_WEIGHT_PARAM %>"
               type="number" step="0.1" required>
    </label><br/>
    Select user activity level:<br>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_ACTIVITY_PARAM %>"
               type="radio" value="<%= Activity.LOW %>" required>
        Low
    </label>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_ACTIVITY_PARAM %>"
               type="radio" value="<%= Activity.AVERAGE %>">
        Average
    </label>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_ACTIVITY_PARAM %>"
               type="radio" value="<%= Activity.HIGH %>">
        High
    </label><br/>
    Select user goal:<br>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_GOAL_PARAM %>"
               type="radio" value="<%= Goal.LOSE_WEIGHT %>" required>
        Lose weight
    </label>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_GOAL_PARAM %>"
               type="radio" value="<%= Goal.KEEP_WEIGHT %>">
        Keep weight
    </label>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_GOAL_PARAM %>"
               type="radio" value="<%= Goal.GAIN_WEIGHT %>">
        Gain weight
    </label><br/>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.USER_DETAILS_LIST_SERVLET %>>
    <button><h1>RETURN TO USER DETAILS LIST</h1></button>
</a><br/>
</body>
</html>