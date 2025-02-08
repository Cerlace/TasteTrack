<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.user.list"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<jsp:include page="${ServletConstants.ALERT_BLOCK_JSP}"/>
<div class="content">
    <div class="line-container">
        <h1><fmt:message key="table.user.list"/>:</h1>
        <form name="save-user"
              method="get"
              action="${ ServletConstants.USER_SAVE_SERVLET }">
            <button type="submit"
                    class="medium-action-button">
                <fmt:message key="table.user.save"/>
            </button>
        </form>
    </div>
    <table>
        <tr>
            <td>
                <fmt:message key="column.id"/>
            </td>
            <td>
                <fmt:message key="table.user.column.full-name"/>
            </td>
            <td>
                <fmt:message key="table.user.column.birth-date"/>
            </td>
            <td>
                <fmt:message key="table.user.column.gender"/>
            </td>
            <td>
                <fmt:message key="table.user.column.email"/>
            </td>
            <td>
                <fmt:message key="table.user.column.height"/>
            </td>
            <td>
                <fmt:message key="table.user.column.weight"/>
            </td>
            <td>
                <fmt:message key="table.user.column.activity"/>
            </td>
            <td>
                <fmt:message key="table.user.column.goal"/>
            </td>
            <td>
                <fmt:message key="table.user.column.user-meals"/>
            </td>
            <td colspan="2">
                <fmt:message key="label.action"/>
            </td>
        </tr>
        <c:forEach var="user" items="${requestScope.userList}">
            <tr>
                <td>
                        ${user.id}
                </td>
                <td>
                        ${user.fullName}
                </td>
                <td>
                    <fmt:formatDate value="${user.birthDate}"/>
                </td>
                <td>
                    <fmt:message key="${user.gender.messageKey}"/>
                </td>
                <td>
                        ${user.email}
                </td>
                <td>
                    <fmt:formatNumber value="${user.height}" minFractionDigits="0"/>&nbsp<fmt:message
                        key="table.user.column.height.unit"/>
                </td>
                <td>
                    <fmt:formatNumber value="${user.weight}" minFractionDigits="0"/>&nbsp<fmt:message
                        key="table.user.column.weight.unit"/>
                </td>
                <td>
                    <fmt:message key="${user.activity.messageKey}"/>
                </td>
                <td>
                    <fmt:message key="${user.goal.messageKey}"/>
                </td>
                <td>
                    <form name="list-meals"
                          method="get"
                          action="${ServletConstants.MEAL_LIST_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.USER_ID_PARAM}"
                                value="${user.id}">
                            <fmt:message key="table.meal.list"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form name="delete"
                          method="post"
                          action="${ServletConstants.USER_DELETE_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.USER_ID_PARAM}"
                                value="${user.id}">
                            <fmt:message key="button.delete"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form name="update"
                          method="get"
                          action="${ServletConstants.USER_UPDATE_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.USER_ID_PARAM}"
                                value="${user.id}">
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