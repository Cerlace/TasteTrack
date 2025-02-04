<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.MealTime" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.meal.update"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<div class="content">

    <jsp:useBean id="mealObject" class="cerlace.tastetrack.dto.MealDTO" scope="request"/>

    <form name="update"
          method="post"
          action="${ServletConstants.MEAL_UPDATE_SERVLET}">
        <h2><fmt:message key="table.meal.update"/>:</h2>
        <input name="${ServletConstants.MEAL_ID_PARAM}"
               type="hidden"
               value="${mealObject.id}"
               required>
        <input name="${ServletConstants.USER_ID_PARAM}"
               type="hidden"
               value="${mealObject.user.id}"
               required>
        <div class="input-group">
            <label for="date-input">
                <fmt:message key="table.meal.column.date"/>:
            </label>
            <input id="date-input"
                   name="${ServletConstants.MEAL_DATE_PARAM}"
                   type="date"
                   value="<fmt:formatDate value="${mealObject.date}" pattern="yyyy-MM-dd"/>"
                   required>
        </div>
        <div class="input-group">
            <fmt:message key="table.meal.column.meal-time"/>
            <label>
                <input name="${ServletConstants.MEAL_TIME_PARAM}"
                       type="radio"
                       value="${MealTime.BREAKFAST}"
                ${mealObject.mealTime == MealTime.BREAKFAST ? "checked" : ""}
                       required>
                <fmt:message key="table.meal.column.meal-time.breakfast"/>
            </label>
            <label>
                <input name="${ServletConstants.MEAL_TIME_PARAM}"
                       type="radio"
                       value="${MealTime.LUNCH}"
                ${mealObject.mealTime == MealTime.LUNCH ? "checked" : ""}>
                <fmt:message key="table.meal.column.meal-time.lunch"/>
            </label>
            <label>
                <input name="${ServletConstants.MEAL_TIME_PARAM}"
                       type="radio"
                       value="${MealTime.DINNER}"
                ${mealObject.mealTime == MealTime.DINNER ? "checked" : ""}>
                <fmt:message key="table.meal.column.meal-time.dinner"/>
            </label>
        </div>

        <jsp:include page="${ServletConstants.DISH_SELECT_SERVLET}"/>

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
                value="${mealObject.user.id}">
            <fmt:message key="table.meal.return"/>
        </button>
    </form>
</div>
</body>
</html>