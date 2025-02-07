<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.ProductType" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.ingredient.update"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<div class="content">

    <jsp:useBean id="ingredientObject" class="cerlace.tastetrack.dto.IngredientDTO" scope="request"/>

    <form name="update"
          method="post"
          action="${ServletConstants.INGREDIENT_UPDATE_SERVLET}">
        <h2><fmt:message key="table.ingredient.update"/>:</h2>
        <input name="${ServletConstants.INGREDIENT_ID_PARAM}"
               type="hidden"
               value="${ingredientObject.id}"
               required>
        <div class="input-group">
            <label for="name-input">
                <fmt:message key="table.ingredient.column.name"/>:
            </label>
            <input id="name-input"
                   name="${ServletConstants.INGREDIENT_NAME_PARAM}"
                   type="text"
                   value="${ingredientObject.name}"
                   required>
        </div>
        <div class="input-group">
            <label for="type-input">
                <fmt:message key="table.ingredient.column.product-type"/>:
            </label>
            <select id="type-input"
                    name="${ServletConstants.INGREDIENT_PRODUCT_TYPE_PARAM}" required>
                <c:forEach var="productType" items="${ProductType.values()}">
                    <option ${ingredientObject.productType == productType ? "selected" : ""} >
                        <fmt:message key="${productType.messageKey}"/>
                    </option>
                </c:forEach>
            </select>
        </div>
        <button type="submit"
                class="medium-action-button">
            <fmt:message key="button.send"/>
        </button>
    </form>
    <form name="list-ingredients"
          method="get"
          action="${ServletConstants.INGREDIENT_LIST_SERVLET}">
        <button type="submit"
                class="medium-action-button">
            <fmt:message key="table.ingredient.return"/>
        </button>
    </form>
</div>
</body>
</html>