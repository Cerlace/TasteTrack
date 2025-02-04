<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.meal.list"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<jsp:include page="${ServletConstants.ALERT_BLOCK_JSP}"/>
<div class="content">
    <div class="line-container">
        <h1><fmt:message key="table.meal.list"/>:</h1>
        <form name="save"
              method="get"
              action="${ServletConstants.MEAL_SAVE_SERVLET}">
            <button type="submit"
                    class="medium-action-button"
                    name="${ServletConstants.USER_ID_PARAM}"
                    value="${param.userId}">
                <fmt:message key="table.meal.save"/>
            </button>
        </form>
    </div>
    <table>
        <tr>
            <td>
                <fmt:message key="column.id"/>
            </td>
            <td>
                <fmt:message key="table.meal.column.date"/>
            </td>
            <td>
                <fmt:message key="table.meal.column.meal-time"/>
            </td>
            <td>
                <fmt:message key="table.dish.column.name"/>
            </td>
            <td colspan="2">
                <fmt:message key="label.action"/>
            </td>
        </tr>
        <c:forEach var="meal" items="${requestScope.mealList}">
            <tr>
                <td>
                        ${meal.id}
                </td>
                <td>
                    <fmt:formatDate value="${meal.date}"/>
                </td>
                <td>
                        ${meal.mealTime}
                </td>
                <td>
                        ${meal.dish.name}
                </td>
                <td>
                    <form name="delete"
                          method="post"
                          action="${ServletConstants.MEAL_DELETE_SERVLET}">
                        <input name="${ServletConstants.USER_ID_PARAM}"
                               type="hidden"
                               value="${meal.user.id}"
                               required>
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.MEAL_ID_PARAM}"
                                value="${meal.id}">
                            <fmt:message key="button.delete"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form name="update"
                          method="get"
                          action="${ServletConstants.MEAL_UPDATE_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.MEAL_ID_PARAM}"
                                value="${meal.id}">
                            <fmt:message key="button.update"/>
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form name="list-users"
          method="get"
          action="${ServletConstants.USER_LIST_SERVLET}">
        <button type="submit"
                class="medium-action-button">
            <fmt:message key="table.user.return"/>
        </button>
    </form>
</div>
</body>
</html>