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
    <title>Save user</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<div class="content">
    <form name="save"
          method="post"
          action="${ServletConstants.USER_SAVE_SERVLET}">
        <h2>Save user:</h2>
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
            <label>
                <input name="${ServletConstants.USER_GENDER_PARAM}"
                       type="radio"
                       value="${Gender.MALE}"
                       required>
                <fmt:message key="table.user.column.gender.male"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_GENDER_PARAM}"
                       type="radio"
                       value="${Gender.FEMALE}">
                <fmt:message key="table.user.column.gender.female"/>
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
            <label>
                <input name="${ServletConstants.USER_ACTIVITY_PARAM}"
                       type="radio"
                       value="${Activity.LOW}"
                       required>
                <fmt:message key="table.user.column.activity.low"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_ACTIVITY_PARAM}"
                       type="radio"
                       value="${Activity.AVERAGE}">
                <fmt:message key="table.user.column.activity.average"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_ACTIVITY_PARAM}"
                       type="radio"
                       value="${Activity.HIGH}">
                <fmt:message key="table.user.column.activity.high"/>
            </label>
        </div>
        <div class="input-group">
            <fmt:message key="table.user.column.goal"/>:
            <label>
                <input name="${ServletConstants.USER_GOAL_PARAM}"
                       type="radio"
                       value="${Goal.LOSE_WEIGHT}"
                       required>
                <fmt:message key="table.user.column.goal.lose"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_GOAL_PARAM}"
                       type="radio"
                       value="${Goal.KEEP_WEIGHT}">
                <fmt:message key="table.user.column.goal.keep"/>
            </label>
            <label>
                <input name="${ServletConstants.USER_GOAL_PARAM}"
                       type="radio"
                       value="${Goal.GAIN_WEIGHT}">
                <fmt:message key="table.user.column.goal.gain"/>
            </label>
        </div>
        <button type="submit"
                class="medium-action-button">
            <fmt:message key="label.send"/>
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