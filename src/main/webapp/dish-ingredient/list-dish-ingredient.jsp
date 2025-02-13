<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.dish-ingredient.list"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<jsp:include page="${ServletConstants.ALERT_BLOCK_JSP}"/>
<div class="content">
    <div class="line-container">
        <h1><fmt:message key="table.dish-ingredient.list"/>:</h1>
        <form name="save"
              method="get"
              action="${ServletConstants.DISH_INGREDIENT_SAVE_SERVLET}">
            <button type="submit"
                    class="medium-action-button"
                    name="${ServletConstants.DISH_ID_PARAM}"
                    value="${param.dishId}">
                <fmt:message key="table.dish-ingredient.save"/>
            </button>
        </form>
    </div>
    <table>
        <tr>
            <td>
                <fmt:message key="column.id"/>
            </td>
            <td>
                <fmt:message key="table.ingredient.column.name"/>
            </td>
            <td>
                <fmt:message key="table.dish-ingredient.column.amount"/>
            </td>
            <td colspan="2">
                <fmt:message key="label.action"/>
            </td>
        </tr>
        <c:forEach var="dishIngredient" items="${requestScope.dishIngredientList}">
            <tr>
                <td>
                        ${dishIngredient.id}
                </td>
                <td>
                        ${dishIngredient.ingredient.name}
                </td>
                <td>
                    <fmt:formatNumber value="${dishIngredient.amount}" minFractionDigits="0"/>&nbsp<fmt:message
                        key="${dishIngredient.measureUnit.messageKey}"/>
                </td>
                <td>
                    <form name="update"
                          method="get"
                          action="${ServletConstants.DISH_INGREDIENT_UPDATE_SERVLET}">
                        <button type="submit"
                                class="small-action-button update"
                                name="${ServletConstants.DISH_INGREDIENT_ID_PARAM}"
                                value="${dishIngredient.id}">
                            <fmt:message key="button.update"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form name="delete"
                          method="post"
                          action="${ServletConstants.DISH_INGREDIENT_DELETE_SERVLET}">
                        <input name="${ServletConstants.DISH_ID_PARAM}"
                               type="hidden"
                               value="${dishIngredient.dish.id}"
                               required>
                        <button type="submit"
                                class="small-action-button delete"
                                onclick="return confirm('<fmt:message key="alert.confirm.delete"/>');"
                                name="${ServletConstants.DISH_INGREDIENT_ID_PARAM}"
                                value="${dishIngredient.id}">
                            <fmt:message key="button.delete"/>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
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