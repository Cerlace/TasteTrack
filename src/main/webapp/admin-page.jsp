<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<h1>Data tables:</h1><br/>
<a href="<%=ServletConstants.USER_LIST_SERVLET %>">
    <button><h1>USERS</h1></button>
</a><br/>
<br/>
<a href="<%= ServletConstants.USER_DETAILS_LIST_SERVLET %>">
    <button><h1>USER DETAILS</h1></button>
</a><br/>
<br/>
<a href="<%= ServletConstants.INGREDIENT_LIST_SERVLET %>">
    <button><h1>INGREDIENTS</h1></button>
</a><br/>
<br/>
<a href="<%= ServletConstants.DISH_LIST_SERVLET %>">
    <button><h1>DISHES</h1></button>
</a><br/>
<br/>
<a href="<%= ServletConstants.MEAL_LIST_SERVLET %>">
    <button><h1>MEALS</h1></button>
</a><br/>
</body>
</html>
