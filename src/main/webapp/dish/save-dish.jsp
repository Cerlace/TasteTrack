<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save dish</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <form name="save"
          method="post"
          action="<%= ServletConstants.DISH_SAVE_SERVLET %>">
        <h2>Save dish:</h2>
        <div class="input-group">
            <label for="name-input">
                Fill dish name:
            </label>
            <input id="name-input"
                   name="<%= ServletConstants.DISH_NAME_PARAM %>"
                   type="text"
                   required>
        </div>
        <div class="input-group">
            <label for="calories-input">
                Fill calories amount:
            </label>
            <input id="calories-input"
                   name="<%= ServletConstants.DISH_CALORIES_PARAM %>"
                   type="number"
                   step="0.1"
                   required>
        </div>
        <div class="input-group">
            <label for="proteins-input">
                Fill proteins amount:
            </label>
            <input id="proteins-input"
                   name="<%= ServletConstants.DISH_PROTEINS_PARAM %>"
                   type="number"
                   step="0.1"
                   required>
        </div>
        <div class="input-group">
            <label for="fats-input">
                Fill fats amount:
            </label>
            <input id="fats-input"
                   name="<%= ServletConstants.DISH_FATS_PARAM %>"
                   type="number"
                   step="0.1"
                   required>
        </div>
        <div class="input-group">
            <label for="carbs-input">
                Fill carbohydrates amount:
            </label>
            <input id="carbs-input"
                   name="<%= ServletConstants.DISH_CARBOHYDRATES_PARAM %>"
                   type="number"
                   step="0.1"
                   required>
        </div>
        <div class="input-group">
            <label for="recipe-input">
                Fill dish recipe:
            </label>
            <textarea rows="10"
                      id="recipe-input"
                      name="<%= ServletConstants.DISH_RECIPE_PARAM %>"
                      required></textarea>
        </div>
        <button type="submit"
                class="medium-action-button">
            Send
        </button>
    </form>
    <form name="list-dish"
          method="get"
          action="<%= ServletConstants.DISH_LIST_SERVLET %>">
        <button type="submit"
                class="medium-action-button">
            Return to dishes
        </button>
    </form>
</div>
</body>
</html>