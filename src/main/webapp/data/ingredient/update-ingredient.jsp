<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.IngredientDTO" %>
<%@ page import="cerlace.tastetrack.enums.ProductType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update ingredient</title>
    <link rel='stylesheet' type='text/css' media='screen'
          href='${pageContext.request.contextPath}/style.css'>
</head>
<body>
<jsp:include page="<%= ServletConstants.SIDEBAR_JSP %>"/>
<div class="content">
    <% IngredientDTO ingredient = (IngredientDTO) request.getAttribute(ServletConstants.INGREDIENT_ATTRIBUTE); %>
    <form name="update"
          method="post"
          action="<%= ServletConstants.INGREDIENT_UPDATE_SERVLET %>">
        <h2>Update ingredient:</h2>
        <input name="<%= ServletConstants.INGREDIENT_ID_PARAM %>"
               type="hidden"
               value="<%= ingredient.getId() %>"
               required>
        <div class="input-group">
            <label for="name-input">
                Fill ingredient name:
            </label>
            <input id="name-input"
                   name="<%= ServletConstants.INGREDIENT_NAME_PARAM %>"
                   type="text"
                   value="<%= ingredient.getName() %>"
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
                <option <%= ingredient.getProductType() == productType ? "selected" : "" %> >
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