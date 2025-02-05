<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.dish-ingredient.update"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<div class="content">

    <jsp:useBean id="dishIngredientObject" class="cerlace.tastetrack.dto.DishIngredientDTO" scope="request"/>

    <form name="update"
          method="post"
          action="${ServletConstants.DISH_INGREDIENT_UPDATE_SERVLET}">
        <h2><fmt:message key="table.dish-ingredient.update"/>:</h2>
        <input name="${ServletConstants.DISH_INGREDIENT_ID_PARAM}"
               type="hidden"
               value="${dishIngredientObject.id}"
               required>
        <input name="${ServletConstants.DISH_ID_PARAM}"
               type="hidden"
               value="${dishIngredientObject.dish.id}"
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
                   value="${dishIngredientObject.amount}"
                   required>
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
                value="${dishIngredientObject.dish.id}">
            <fmt:message key="table.dish-ingredient.return"/>
        </button>
    </form>
</div>
</body>
</html>