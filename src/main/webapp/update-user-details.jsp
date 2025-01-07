<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.UserDetailsDTO" %>
<%@ page import="cerlace.tastetrack.enums.Goal" %>
<%@ page import="cerlace.tastetrack.enums.Activity" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update user details</title>
</head>
<body>
<% UserDetailsDTO userDetails = (UserDetailsDTO) request.getAttribute(ServletConstants.USER_DETAILS_ATTRIBUTE); %>
<h2>Update user details:</h2>
<form name="update"
      method="post"
      action="<%= ServletConstants.USER_DETAILS_UPDATE_SERVLET %>">
    <input name="<%= ServletConstants.USER_DETAILS_ID_PARAM %>"
           type="hidden"
           value="<%= userDetails.getId() %>"
           required>
    <label>
        Fill new user height:
        <input name="<%= ServletConstants.USER_DETAILS_HEIGHT_PARAM %>"
               type="number"
               step="0.1"
               value="<%= userDetails.getHeight() %>"
               required>
    </label><br/>
    <label>
        Fill new user weight:
        <input name="<%= ServletConstants.USER_DETAILS_WEIGHT_PARAM %>"
               type="number"
               step="0.1"
               value="<%= userDetails.getWeight() %>"
               required>
    </label><br/>
    Select new user activity level:<br>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_ACTIVITY_PARAM %>"
               type="radio"
               value="<%= Activity.LOW %>"
               required
            <%= userDetails.getActivity() == Activity.LOW ? "checked" : "" %>>
        Low
    </label>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_ACTIVITY_PARAM %>"
               type="radio"
               value="<%= Activity.AVERAGE %>"
            <%= userDetails.getActivity() == Activity.AVERAGE ? "checked" : "" %>>
        Average
    </label>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_ACTIVITY_PARAM %>"
               type="radio"
               value="<%= Activity.HIGH %>"
            <%= userDetails.getActivity() == Activity.HIGH ? "checked" : "" %>>
        High
    </label><br/>
    Select new user goal:<br>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_GOAL_PARAM %>"
               type="radio"
               value="<%= Goal.LOSE_WEIGHT %>"
               required
            <%= userDetails.getGoal() == Goal.LOSE_WEIGHT ? "checked" : "" %>>
        Lose weight
    </label>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_GOAL_PARAM %>"
               type="radio"
               value="<%= Goal.KEEP_WEIGHT %>"
            <%= userDetails.getGoal() == Goal.KEEP_WEIGHT ? "checked" : "" %>>
        Keep weight
    </label>
    <label>
        <input name="<%= ServletConstants.USER_DETAILS_GOAL_PARAM %>"
               type="radio"
               value="<%= Goal.GAIN_WEIGHT %>"
            <%= userDetails.getGoal() == Goal.GAIN_WEIGHT ? "checked" : "" %>>
        Gain weight
    </label><br/>
    <button>Send</button>
</form>
<br/>
<a href="<%= ServletConstants.USER_DETAILS_LIST_SERVLET %>">RETURN TO USER DETAILS LIST </a><br/>
</body>
</html>