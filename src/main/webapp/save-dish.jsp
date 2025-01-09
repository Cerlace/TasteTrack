<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save dish</title>
</head>
<body>
<h2>Save dish:</h2>
<form name="save"
      method="post"
      action="<%= ServletConstants.DISH_SAVE_SERVLET %>">
    <label>
        Fill dish name:
        <input name="<%= ServletConstants.DISH_NAME_PARAM %>" type="text" required>
    </label><br/>
    <label>
        Fill calories amount:
        <input name="<%= ServletConstants.DISH_CALORIES_PARAM %>"
               type="number"
               step="0.1"
               required>
    </label><br/>
    <label>
        Fill proteins amount:
        <input name="<%= ServletConstants.DISH_PROTEINS_PARAM %>"
               type="number"
               step="0.1"
               required>
    </label><br/>
    <label>
        Fill fats amount:
        <input name="<%= ServletConstants.DISH_FATS_PARAM %>"
               type="number"
               step="0.1"
               required>
    </label><br/>
    <label>
        Fill carbohydrates amount:
        <input name="<%= ServletConstants.DISH_CARBOHYDRATES_PARAM %>"
               type="number"
               step="0.1"
               required>
    </label><br/>
    <label>
        Fill dish recipe:
        <input name="<%= ServletConstants.DISH_RECIPE_PARAM %>" type="text" required>
    </label><br/>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.DISH_LIST_SERVLET %>>
    <button><h1>RETURN TO DISH LIST</h1></button>
</a><br/>
</body>
</html>