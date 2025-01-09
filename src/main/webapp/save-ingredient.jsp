<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.enums.ProductType" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Save ingredient</title>
</head>
<body>
<h2>Save ingredient:</h2>
<form name="save"
      method="post"
      action="<%= ServletConstants.INGREDIENT_SAVE_SERVLET %>">
    <label>
        Fill ingredient name:
        <input name="<%= ServletConstants.INGREDIENT_NAME_PARAM %>" type="text" required>
    </label><br/>
    <label>
        Choose product type:
        <select name="<%= ServletConstants.INGREDIENT_PRODUCT_TYPE_PARAM %>" required>
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
    </label>
    <button>Send</button>
</form>
<br/>
<a href=<%= ServletConstants.INGREDIENT_LIST_SERVLET %>>
    <button><h1>RETURN TO INGREDIENT LIST</h1></button>
</a><br/>
</body>
</html>