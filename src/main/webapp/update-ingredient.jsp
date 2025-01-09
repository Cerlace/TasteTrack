<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.IngredientDTO" %>
<%@ page import="cerlace.tastetrack.enums.ProductType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Update ingredient</title>
</head>
<body>
<% IngredientDTO ingredient = (IngredientDTO) request.getAttribute(ServletConstants.INGREDIENT_ATTRIBUTE); %>
<h2>Update ingredient:</h2>
<form name="update"
      method="post"
      action="<%= ServletConstants.INGREDIENT_UPDATE_SERVLET %>">
    <input name="<%= ServletConstants.INGREDIENT_ID_PARAM %>"
           type="hidden"
           value="<%= ingredient.getId() %>"
           required>
    <label>
        Fill new user full name:
        <input name="<%= ServletConstants.INGREDIENT_NAME_PARAM %>"
               type="text"
               value="<%= ingredient.getName() %>"
               required>
    </label><br/>
    <label>
        Choose product type:
        <select name="<%= ServletConstants.INGREDIENT_PRODUCT_TYPE_PARAM %>" required>
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
    </label>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.INGREDIENT_LIST_SERVLET %>>
    <button><h1>RETURN TO INGREDIENT LIST</h1></button>
</a><br/>
</body>
</html>