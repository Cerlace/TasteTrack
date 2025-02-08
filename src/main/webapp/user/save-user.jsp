<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.Gender" %>
<%@ page import="cerlace.tastetrack.enums.Activity" %>
<%@ page import="cerlace.tastetrack.enums.Goal" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.user.save"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<div class="content">
    <form name="save"
          method="post"
          action="${ServletConstants.USER_SAVE_SERVLET}">
        <h2><fmt:message key="table.user.save"/>:</h2>
        <div class="input-group">
            <label for="name-input">
                <fmt:message key="table.user.column.full-name"/>:
            </label>
            <input id="name-input"
                   name="${ServletConstants.USER_FULL_NAME_PARAM}"
                   type="text"
                   required>
        </div>
        <div class="input-group">
            <label for="email-input">
                <fmt:message key="table.user.column.email"/>:
            </label>
            <input id="email-input"
                   name="${ServletConstants.USER_EMAIL_PARAM}"
                   type="email"
                   required>
        </div>
        <div class="input-group">
            <label for="birthdate-input">
                <fmt:message key="table.user.column.birth-date"/>:
            </label>
            <input id="birthdate-input"
                   name="${ServletConstants.USER_BIRTHDATE_PARAM}"
                   type="date"
                   required>
        </div>
        <div class="input-group">
            <fmt:message key="table.user.column.gender"/>:
            <c:forEach var="gender" items="${Gender.values()}">
                <label>
                    <input name="${ServletConstants.USER_GENDER_PARAM}"
                           type="radio"
                           value="${gender}"
                           required>
                    <fmt:message key="${gender.messageKey}"/>
                </label>
            </c:forEach>
        </div>
        <div class="input-group">
            <label for="height-input">
                <fmt:message key="table.user.column.height"/>:
            </label>
            <input id="height-input"
                   name="${ServletConstants.USER_HEIGHT_PARAM}"
                   type="number"
                   step="0.1"
                   min="0.1"
                   required>
        </div>
        <div class="input-group">
            <label for="weight-input">
                <fmt:message key="table.user.column.weight"/>:
            </label>
            <input id="weight-input"
                   name="${ServletConstants.USER_WEIGHT_PARAM}"
                   type="number"
                   step="0.1"
                   min="0.1"
                   required>
        </div>
        <div class="input-group">
            <fmt:message key="table.user.column.activity"/>:
            <c:forEach var="activity" items="${Activity.values()}">
                <label>
                    <input name="${ServletConstants.USER_ACTIVITY_PARAM}"
                           type="radio"
                           value="${activity}"
                           required>
                    <fmt:message key="${activity.messageKey}"/>
                </label>
            </c:forEach>
        </div>
        <div class="input-group">
            <fmt:message key="table.user.column.goal"/>:
            <c:forEach var="goal" items="${Goal.values()}">
                <label>
                    <input name="${ServletConstants.USER_GOAL_PARAM}"
                           type="radio"
                           value="${goal}"
                           required>
                    <fmt:message key="${goal.messageKey}"/>
                </label>
            </c:forEach>
        </div>
        <button type="submit"
                class="medium-action-button">
            <fmt:message key="button.send"/>
        </button>
    </form>
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