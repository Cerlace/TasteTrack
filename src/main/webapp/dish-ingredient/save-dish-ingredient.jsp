<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.MeasureUnit" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.dish-ingredient.save"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<div class="content">
    <form name="save"
          method="post"
          action="${ServletConstants.DISH_INGREDIENT_SAVE_SERVLET}">
        <h2><fmt:message key="table.dish-ingredient.save"/>:</h2>
        <input name="${ServletConstants.DISH_ID_PARAM}"
               type="hidden"
               value="${param.dishId}"
               required>

        <jsp:include page="${ServletConstants.INGREDIENT_SELECT_SERVLET}"/>

        <div class="input-group">
            <label for="amount-input">
                <fmt:message key="table.dish-ingredient.column.amount"/>:
            </label>
            <input id="amount-input"
                   name="${ServletConstants.DISH_INGREDIENT_AMOUNT_PARAM}"
                   type="number"
                   step="0.1"
                   min="0.1"
                   required>
        </div>
        <div class="input-group">
            <label for="unit-input">
                <fmt:message key="table.dish-ingredient.column.measure-unit"/>:
            </label>
            <select id="unit-input"
                    name="${ServletConstants.DISH_INGREDIENT_MEASURE_UNIT_PARAM}"
                    required>
                <c:forEach var="measureUnit" items="${MeasureUnit.values()}">
                    <option value="${measureUnit}">
                        <fmt:message key="${measureUnit.messageKey}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit"
                class="medium-action-button">
            <fmt:message key="button.send"/>
        </button>
    </form>
    <form name="list-dish-ingredients"
          method="get"
          action="${ServletConstants.DISH_INGREDIENT_LIST_SERVLET}">
        <button type="submit"
                class="medium-action-button"
                name="${ServletConstants.DISH_ID_PARAM}"
                value="${param.dishId}">
            <fmt:message key="table.dish-ingredient.return"/>
        </button>
    </form>
</div>
</body>
</html>