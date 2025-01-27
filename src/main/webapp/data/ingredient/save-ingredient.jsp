<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.ProductType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save ingredient</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <form name="save"
          method="post"
          action="<%= ServletConstants.INGREDIENT_SAVE_SERVLET %>">
        <h2>Save ingredient:</h2>
        <div class="input-group">
            <label for="name-input">
                Fill ingredient name:
            </label>
            <input id="name-input"
                   name="<%= ServletConstants.INGREDIENT_NAME_PARAM %>"
                   type="text"
                   required>
        </div>
        <div class="input-group">
            <label for="type-input">
                Choose product type:
            </label>
            <select id="type-input"
                    name="<%= ServletConstants.INGREDIENT_PRODUCT_TYPE_PARAM %>" required>
                <%
                    for (ProductType productType : ProductType.values()) {
                %>
                <option>
                    <%= productType %>
                </option>
                <%
                    }
                %>
            </select>
        </div>
        <button type="submit"
                class="medium-action-button">
            Send
        </button>
    </form>
    <form name="list-ingredients"
          method="get"
          action="<%= ServletConstants.INGREDIENT_LIST_SERVLET %>">
        <button type="submit"
                class="medium-action-button">
            Return to ingredients
        </button>
    </form>
</div>
</body>
</html>