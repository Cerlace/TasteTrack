<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>

<fmt:setLocale value="${not empty cookie.locale ? cookie.locale.value : 'en'}"/>
<fmt:setBundle basename="messages"/>
<html>
<head>
    <title><fmt:message key="table.ingredient.list"/></title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="${ServletConstants.SIDEBAR_JSP}"/>
<jsp:include page="${ServletConstants.ALERT_BLOCK_JSP}"/>
<div class="content">
    <div class="line-container">
        <h1><fmt:message key="table.ingredient.list"/>:</h1>
        <form name="save-ingredient"
              method="get"
              action="${ServletConstants.INGREDIENT_SAVE_SERVLET}">
            <button type="submit"
                    class="medium-action-button">
                <fmt:message key="table.ingredient.save"/>
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
                <fmt:message key="table.ingredient.column.product-type"/>
            </td>
            <td colspan="2">
                <fmt:message key="label.action"/>
            </td>
        </tr>
        <c:forEach var="ingredient" items="${requestScope.ingredientList}">
            <tr>
                <td>
                        ${ingredient.id}
                </td>
                <td>
                        ${ingredient.name}
                </td>
                <td>
                        ${ingredient.productType}
                </td>
                <td>
                    <form name="delete"
                          method="post"
                          action="${ServletConstants.INGREDIENT_DELETE_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.INGREDIENT_ID_PARAM}"
                                value="${ingredient.id}">
                            <fmt:message key="button.delete"/>
                        </button>
                    </form>
                </td>
                <td>
                    <form name="update"
                          method="get"
                          action="${ServletConstants.INGREDIENT_UPDATE_SERVLET}">
                        <button type="submit"
                                class="small-action-button"
                                name="${ServletConstants.INGREDIENT_ID_PARAM}"
                                value="${ingredient.id}">
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