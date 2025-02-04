<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>

<html>
<body>
<div class="sidebar">
    <div style="display: flex; flex-direction: column;">
        <form name="list-users"
              method="get"
              action="<%= ServletConstants.USER_LIST_SERVLET %>">
            <button type="submit"
                    class="menu-button">
                <fmt:message key="table.user.label"/>
            </button>
        </form>
        <form name="list-ingredients"
              method="get"
              action="<%= ServletConstants.INGREDIENT_LIST_SERVLET %>">
            <button type="submit"
                    class="menu-button">
                <fmt:message key="table.ingredient.label"/>
            </button>
        </form>
        <form name="list-dishes"
              method="get"
              action="<%= ServletConstants.DISH_LIST_SERVLET %>">
            <button type="submit"
                    class="menu-button">
                <fmt:message key="table.dish.label"/>
            </button>
        </form>
    </div>
    <jsp:include page="${ServletConstants.LANGUAGE_SWITCH_JSP}"/>
</div>
</body>
</html>
