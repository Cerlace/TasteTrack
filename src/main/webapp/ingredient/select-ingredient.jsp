<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<body>

<jsp:useBean id="dishIngredientObject" class="cerlace.tastetrack.dto.DishIngredientDTO" scope="request"/>

<div class="input-group">
    <label for="ingredient-select">
        <fmt:message key="table.ingredient.column.name"/>:
    </label>
    <select id="ingredient-select"
            name="${ServletConstants.INGREDIENT_ID_PARAM}" required>
        <c:forEach var="ingredient" items="${requestScope.ingredientList}">
            <option value="${ingredient.id}"
                ${dishIngredientObject != null && dishIngredientObject.ingredient.id == ingredient.id
                        ? "selected" : ""}>
                    ${ingredient.name}
            </option>
        </c:forEach>
    </select>
</div>
</body>
</html>
