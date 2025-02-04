<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.MealTime" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.meal.save"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <form name="save"
          method="post"
          action="<%= ServletConstants.MEAL_SAVE_SERVLET %>">
        <h2><fmt:message key="table.meal.save"/>:</h2>
        <input name="<%= ServletConstants.USER_ID_PARAM %>"
               type="hidden"
               value="<%= request.getParameter(ServletConstants.USER_ID_PARAM) %>"
               required>
        <div class="input-group">
            <label for="date-input">
                <fmt:message key="table.meal.column.date"/>:
            </label>
            <input id="date-input"
                   name="${ServletConstants.MEAL_DATE_PARAM}"
                   type="date"
                   required>
        </div>
        <div class="input-group">
            <fmt:message key="table.meal.column.meal-time"/>
            <label>
                <input name="${ServletConstants.MEAL_TIME_PARAM}"
                       type="radio"
                       value="${MealTime.BREAKFAST}"
                       required>
                <fmt:message key="table.meal.column.meal-time.breakfast"/>
            </label>
            <label>
                <input name="${ServletConstants.MEAL_TIME_PARAM}"
                       type="radio"
                       value="${MealTime.LUNCH}">
                <fmt:message key="table.meal.column.meal-time.lunch"/>
            </label>
            <label>
                <input name="${ServletConstants.MEAL_TIME_PARAM}"
                       type="radio"
                       value="${MealTime.DINNER}">
                <fmt:message key="table.meal.column.meal-time.dinner"/>
            </label>
        </div>

        <jsp:include page="<%= ServletConstants.DISH_SELECT_SERVLET %>"/>

        <button type="submit"
                class="medium-action-button">
            <fmt:message key="button.send"/>
        </button>
    </form>
    <form name="list-meals"
          method="get"
          action="${ServletConstants.MEAL_LIST_SERVLET}">
        <button type="submit"
                class="medium-action-button"
                name="${ServletConstants.USER_ID_PARAM}"
                value="${param.userId}">
            <fmt:message key="table.meal.return"/>
        </button>
    </form>
</div>
</body>
</html>