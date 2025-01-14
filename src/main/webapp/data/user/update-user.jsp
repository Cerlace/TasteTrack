<%@ page import="cerlace.tastetrack.dto.UserDTO" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.Gender" %>
<%@ page import="cerlace.tastetrack.enums.Activity" %>
<%@ page import="cerlace.tastetrack.enums.Goal" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>
<% UserDTO user = (UserDTO) request.getAttribute(ServletConstants.USER_ATTRIBUTE); %>
<h2>Update user:</h2>
<form name="update"
      method="post"
      action="<%= ServletConstants.USER_UPDATE_SERVLET %>">
    <input name="<%= ServletConstants.USER_ID_PARAM %>"
           type="hidden"
           value="<%= user.getId() %>"
           required>
    <label>
        Fill new user full name:
        <input name="<%= ServletConstants.USER_FULL_NAME_PARAM %>"
               type="text"
               value="<%= user.getFullName() %>"
               required>
    </label><br/>
    <label>
        Fill new user email:
        <input name="<%= ServletConstants.USER_EMAIL_PARAM %>"
               type="email"
               value="<%= user.getEmail() %>"
               required>
    </label><br/>
    <label>
        Fill new user birthdate:
        <input name="<%= ServletConstants.USER_BIRTHDATE_PARAM %>"
               type="date"
               value="<%= ServletConstants.DATE_FORMATTER.format(user.getBirthDate()) %>"
               required>
    </label><br/>
    Select new gender:<br>
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
    </label><br/>
    <label>
        Fill new user height:
        <input name="<%= ServletConstants.USER_HEIGHT_PARAM %>"
               type="number"
               step="0.1"
               value="<%= user.getHeight() %>"
               required>
    </label><br/>
    <label>
        Fill new user weight:
        <input name="<%= ServletConstants.USER_WEIGHT_PARAM %>"
               type="number"
               step="0.1"
               value="<%= user.getWeight() %>"
               required>
    </label><br/>
    Select new user activity level:<br>
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
    </label><br/>
    Select new user goal:<br>
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
    </label><br/>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.USER_LIST_SERVLET %>>
    <button><h1>RETURN TO USER LIST</h1></button>
</a><br/>
</body>
</html>