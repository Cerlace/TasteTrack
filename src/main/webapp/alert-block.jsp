<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cerlace.tastetrack.enums.AlertCode" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<script>
    function closeAlert(closeButton) {
        const alert = closeButton.parentElement;
        alert.style.opacity = "0";
        setTimeout(function () {
            alert.style.display = "none";
        }, 600);
    }
</script>
<div class="alert_block">
    <c:choose>
        <c:when test="${sessionScope.alertType == AlertCode.SUCCESS}">
            <div class="alert success">
                <span class="close-button" onclick="closeAlert(this)">&times</span>
                <strong>Success!</strong> ${sessionScope.alertMessage}
            </div>
        </c:when>
        <c:when test="${sessionScope.alertType == AlertCode.INFO}">
            <div class="alert info">
                <span class="close-button" onclick="closeAlert(this)">&times</span>
                <strong>Info message:</strong> ${sessionScope.alertMessage}
            </div>
        </c:when>
        <c:when test="${sessionScope.alertType == AlertCode.WARNING}">
            <div class="alert warning">
                <span class="close-button" onclick="closeAlert(this)">&times</span>
                <strong>Warning!</strong> ${sessionScope.alertMessage}
            </div>
        </c:when>
        <c:when test="${sessionScope.alertType == AlertCode.ERROR}">
            <div class="alert error">
                <span class="close-button" onclick="closeAlert(this)">&times</span>
                <strong>Error!</strong> ${sessionScope.alertMessage}
            </div>
        </c:when>
    </c:choose>
    <c:remove var="alertType" scope="session"/>
    <c:remove var="alertMessage" scope="session"/>
</div>
</body>
</html>
