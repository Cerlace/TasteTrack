<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.Gender" %>
<%@ page import="cerlace.tastetrack.enums.Activity" %>
<%@ page import="cerlace.tastetrack.enums.Goal" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.user.update"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<div class="content">

    <jsp:useBean id="userObject" class="cerlace.tastetrack.dto.UserDTO" scope="request"/>

    <form name="update"
          method="post"
          action="${ServletConstants.USER_UPDATE_SERVLET}">
        <h2><fmt:message key="table.user.update"/>:</h2>
        <input name="${ServletConstants.USER_ID_PARAM}"
               type="hidden"
               value="${userObject.id}"
               required>
        <div class="input-group">
            <label for="name-input">
                <fmt:message key="table.user.column.full-name"/>:
            </label>
            <input id="name-input"
                   name="${ServletConstants.USER_FULL_NAME_PARAM}"
                   type="text"
                   value="${userObject.fullName}"
                   required>
        </div>
        <div class="input-group">
            <label for="email-input">
                <fmt:message key="table.user.column.email"/>:
            </label>
            <input id="email-input"
                   name="${ServletConstants.USER_EMAIL_PARAM}"
                   type="email"
                   value="${userObject.email}"
                   required>
        </div>
        <div class="input-group">
            <label for="birthdate-input">
                <fmt:message key="table.user.column.birth-date"/>:
            </label>
            <input id="birthdate-input"
                   name="${ServletConstants.USER_BIRTHDATE_PARAM}"
                   type="date"
                   value="<fmt:formatDate value="${userObject.birthDate}" pattern="yyyy-MM-dd"/>"
                   required>
        </div>
        <div class="input-group">
            <fmt:message key="table.user.column.gender"/>:
            <label>
                <input name="${ServletConstants.USER_GENDER_PARAM}"
                       type="radio"
                       value="${Gender.MALE}"
                       required
                ${userObject.gender == Gender.MALE ? "checked" : ""}>
                <fmt:message key="${Gender.MALE.messageKey}"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_GENDER_PARAM}"
                       type="radio"
                       value="${Gender.FEMALE}"
                ${userObject.gender == Gender.FEMALE ? "checked" : ""}>
                <fmt:message key="${Gender.FEMALE.messageKey}"/>
            </label>
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
                   value="${userObject.height}"
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
                   value="${userObject.weight}"
                   required>
        </div>
        <div class="input-group">
            <fmt:message key="table.user.column.activity"/>:
            <label>
                <input name="${ServletConstants.USER_ACTIVITY_PARAM}"
                       type="radio"
                       value="${Activity.LOW}"
                       required
                ${userObject.activity == Activity.LOW ? "checked" : ""}>
                <fmt:message key="${Activity.LOW.messageKey}"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_ACTIVITY_PARAM}"
                       type="radio"
                       value="${Activity.AVERAGE}"
                ${userObject.activity == Activity.AVERAGE ? "checked" : ""}>
                <fmt:message key="${Activity.AVERAGE.messageKey}"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_ACTIVITY_PARAM}"
                       type="radio"
                       value="${Activity.HIGH}"
                ${userObject.activity == Activity.HIGH ? "checked" : ""}>
                <fmt:message key="${Activity.HIGH.messageKey}"/>
            </label>
        </div>
        <div class="input-group">
            <fmt:message key="table.user.column.goal"/>:
            <label>
                <input name="${ServletConstants.USER_GOAL_PARAM}"
                       type="radio"
                       value="${Goal.LOSE_WEIGHT}"
                       required
                ${userObject.goal == Goal.LOSE_WEIGHT ? "checked" : ""}>
                <fmt:message key="${Goal.LOSE_WEIGHT.messageKey}"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_GOAL_PARAM}"
                       type="radio"
                       value="${Goal.KEEP_WEIGHT}"
                ${userObject.goal == Goal.KEEP_WEIGHT ? "checked" : ""}>
                <fmt:message key="${Goal.KEEP_WEIGHT.messageKey}"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_GOAL_PARAM}"
                       type="radio"
                       value="${Goal.GAIN_WEIGHT}"
                ${userObject.goal == Goal.GAIN_WEIGHT ? "checked" : ""}>
                <fmt:message key="${Goal.GAIN_WEIGHT.messageKey}"/>
            </label>
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