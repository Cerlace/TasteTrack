<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.dish.list"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<jsp:include page="${ServletConstants.ALERT_BLOCK_JSP}"/>
<div class="content">
    <div class="line-container">
        <h1><fmt:message key="table.dish.list"/>:</h1>
        <form name="save-dish"
              method="get"
              action="${ServletConstants.DISH_SAVE_SERVLET}">
            <button type="submit"
                    class="medium-action-button">
                <fmt:message key="table.dish.save"/>
            </button>
        </form>
    </div>
    <table>
        <tr>
            <td>
                <fmt:message key="column.id"/>
            </td>
            <td>
                <fmt:message key="table.dish.column.name"/>
            </td>
            <td>
                <fmt:message key="table.dish-ingredient.label"/>
            </td>
            <td>
                <fmt:message key="table.dish.column.calories"/>
            </td>
            <td>
                <fmt:message key="table.dish.column.proteins"/>
            </td>
            <td>
                <fmt:message key="table.dish.column.fats"/>
            </td>
            <td>
                <fmt:message key="table.dish.column.carbohydrates"/>
            </td>
            <td>
                <fmt:message key="table.dish.column.recipe"/>
            </td>
            <td colspan="2">
                <fmt:message key="label.action"/>
            </td>
        </tr>
        <c:forEach var="dish" items="${requestScope.dishList}">
            <tr>
                <td>
                        ${dish.id}
                </td>
                <td>
                        ${dish.name}
                </td>
                <td>
                    <form name="list-dish-ingredients"
                          method="get"
                          action="${ServletConstants.DISH_INGREDIENT_LIST_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.DISH_ID_PARAM}"
                                value="${dish.id}">
                            <fmt:message key="table.dish-ingredient.list"/>
                        </button>
                    </form>
                </td>
                <td>
                        ${dish.calories}
                </td>
                <td>
                        ${dish.proteins}
                </td>
                <td>
                        ${dish.fats}
                </td>
                <td>
                        ${dish.carbohydrates}
                </td>
                <td>
                        ${dish.recipe}
                </td>
                <td>
                    <form name="delete"
                          method="post"
                          action="${ServletConstants.DISH_DELETE_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.DISH_ID_PARAM}"
                                value="${dish.id}">
                            <fmt:message key="button.delete"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form name="update"
                          method="get"
                          action="${ServletConstants.DISH_UPDATE_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.DISH_ID_PARAM}"
                                value="${dish.id}">
                            <fmt:message key="button.update"/>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>