<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.DishType" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.dish.save"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<div class="content">
    <form name="save"
          method="post"
          action="${ServletConstants.DISH_SAVE_SERVLET}">
        <h2><fmt:message key="table.dish.save"/>:</h2>
        <div class="input-group">
            <label for="name-input">
                <fmt:message key="table.dish.column.name"/>:
            </label>
            <input id="name-input"
                   name="${ServletConstants.DISH_NAME_PARAM}"
                   type="text"
                   required>
        </div>
        <div class="input-group">
            <label for="type-input">
                <fmt:message key="table.dish.column.type"/>:
            </label>
            <select id="type-input"
                    name="${ServletConstants.DISH_TYPE_PARAM}"
                    required>
                <c:forEach var="dishType" items="${DishType.values()}">
                    <option value="${dishType}">
                        <fmt:message key="${dishType.messageKey}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="input-group">
            <label for="calories-input">
                <fmt:message key="table.dish.column.calories"/>:
            </label>
            <input id="calories-input"
                   name="${ServletConstants.DISH_CALORIES_PARAM}"
                   type="number"
                   step="0.1"
                   min="0"
                   required>
        </div>
        <div class="input-group">
            <label for="proteins-input">
                <fmt:message key="table.dish.column.proteins"/>:
            </label>
            <input id="proteins-input"
                   name="${ServletConstants.DISH_PROTEINS_PARAM}"
                   type="number"
                   step="0.1"
                   min="0"
                   required>
        </div>
        <div class="input-group">
            <label for="fats-input">
                <fmt:message key="table.dish.column.fats"/>:
            </label>
            <input id="fats-input"
                   name="${ServletConstants.DISH_FATS_PARAM}"
                   type="number"
                   step="0.1"
                   min="0"
                   required>
        </div>
        <div class="input-group">
            <label for="carbs-input">
                <fmt:message key="table.dish.column.carbohydrates"/>:
            </label>
            <input id="carbs-input"
                   name="${ServletConstants.DISH_CARBOHYDRATES_PARAM}"
                   type="number"
                   step="0.1"
                   min="0"
                   required>
        </div>
        <div class="input-group">
            <label for="recipe-input">
                <fmt:message key="table.dish.column.recipe"/>:
            </label>
            <textarea rows="10"
                      id="recipe-input"
                      name="${ServletConstants.DISH_RECIPE_PARAM}"
                      required></textarea>
        </div>
        <button type="submit"
                class="medium-action-button">
            <fmt:message key="button.send"/>
        </button>
    </form>
    <form name="list-dish"
          method="get"
          action="${ServletConstants.DISH_LIST_SERVLET}">
        <button type="submit"
                class="medium-action-button">
            <fmt:message key="table.dish.return"/>
        </button>
    </form>
</div>
</body>
</html>