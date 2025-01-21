<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save dish ingredient</title>
</head>
<body>
<h2>Save dish ingredient:</h2>
<form name="save"
      method="post"
      action="<%= ServletConstants.DISH_INGREDIENT_SAVE_SERVLET %>">
    <input name="<%= ServletConstants.DISH_ID_PARAM %>"
           type="hidden"
           value="<%= request.getParameter(ServletConstants.DISH_ID_PARAM) %>"
           required>
    <jsp:include page="<%= ServletConstants.INGREDIENT_SELECT_SERVLET %>"/>
    <br/>
    <label>
        Fill amount:
        <input name="<%= ServletConstants.DISH_INGREDIENT_AMOUNT_PARAM %>"
               type="number"
               step="0.1"
               required>
    </label><br/>
    <button>Send</button>
</form>
<br/>
<form name="list-dish-ingredients"
      method="get"
      action="<%= ServletConstants.DISH_INGREDIENT_LIST_SERVLET %>">
    <button name="<%= ServletConstants.DISH_ID_PARAM %>"
            value="<%= request.getParameter(ServletConstants.DISH_ID_PARAM) %>">
        <h1>RETURN TO DISH INGREDIENT LIST</h1>
    </button>
</form>
<br/>
</body>
</html>