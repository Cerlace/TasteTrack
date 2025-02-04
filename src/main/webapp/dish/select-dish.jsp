<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<body>

<jsp:useBean id="mealObject" class="cerlace.tastetrack.dto.MealDTO" scope="request"/>

<div class="input-group">
    <label for="dish-select">
        <fmt:message key="table.dish.column.name"/>:
    </label>
    <select id="dish-select"
            name="${ServletConstants.DISH_ID_PARAM}" required>
        <c:forEach var="dish" items="${requestScope.dishList}">
            <option value="${dish.id}"
                ${mealObject != null && mealObject.dish.id == dish.id ? "selected" : ""}>
                    ${dish.name}
            </option>
        </c:forEach>
    </select>
</div>
</body>
</html>
