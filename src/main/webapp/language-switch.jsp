<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<body>
<div class="lang-switcher">
    <form name="en-lang"
          id="en-lang"
          method="get"
          action="">
        <c:forEach var="paramEntry" items="${param}">
            <input type="hidden"
                   name="${paramEntry.key}"
                   value="${paramEntry.value}"/>
        </c:forEach>
    </form>
    <button form="en-lang"
            type="submit"
            class="lang-button"
            name="${ServletConstants.COOKIE_LOCALE_PARAM}"
            value="en"
            <c:if test="${empty cookie.locale || cookie.locale.value == 'en'}">
                disabled
            </c:if>>
        <fmt:message key="lang.en"/>
    </button>
    <form name="ru-lang"
          id="ru-lang"
          method="get"
          action="">
        <c:forEach var="paramEntry" items="${param}">
            <input type="hidden"
                   name="${paramEntry.key}"
                   value="${paramEntry.value}"/>
        </c:forEach>
    </form>
    <button form="ru-lang"
            type="submit"
            class="lang-button"
            name="${ServletConstants.COOKIE_LOCALE_PARAM}"
            value="ru"
    ${cookie.locale.value == 'ru' ? 'disabled' : ''}>
        <fmt:message key="lang.ru"/>
    </button>
</div>
</body>
</html>
