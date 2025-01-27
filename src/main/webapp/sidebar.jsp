<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<div class="sidebar">
    <form name="list-users"
          method="get"
          action="<%= ServletConstants.USER_LIST_SERVLET %>">
        <button type="submit"
                class="menu-button">
            Users
        </button>
    </form>
    <form name="list-ingredients"
          method="get"
          action="<%= ServletConstants.INGREDIENT_LIST_SERVLET %>">
        <button type="submit"
                class="menu-button">
            Ingredients
        </button>
    </form>
    <form name="list-dishes"
          method="get"
          action="<%= ServletConstants.DISH_LIST_SERVLET %>">
        <button type="submit"
                class="menu-button">
            Dishes
        </button>
    </form>
</div>
</body>
</html>
