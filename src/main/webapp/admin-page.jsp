<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Admin Page</title>
</head>
<body>
<a href="<%=ServletConstants.USER_LIST_SERVLET %>">
    <button><h1>USERS PAGE</h1></button>
</a><br/>
<br/>
<a href="<%= ServletConstants.USER_DETAILS_LIST_SERVLET %>">
    <button><h1>USER DETAILS PAGE</h1></button>
</a><br/>
<br/>

</body>
</html>
