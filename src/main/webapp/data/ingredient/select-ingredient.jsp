<%@ page import="cerlace.tastetrack.dto.IngredientDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.DishIngredientDTO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<% DishIngredientDTO updatingIngredient = (DishIngredientDTO) request.getAttribute(ServletConstants.DISH_INGREDIENT_ATTRIBUTE); %>
<div class="input-group">
    <label for="ingredient-select">
        Select ingredient:
    </label>
    <select id="ingredient-select"
            name="<%= ServletConstants.INGREDIENT_ID_PARAM %>" required>
        <% List<IngredientDTO> ingredients = (List<IngredientDTO>) request.getAttribute(ServletConstants.INGREDIENT_LIST_ATTRIBUTE);
            for (IngredientDTO ingredient : ingredients) {
        %>
        <option value="<%= ingredient.getId() %>"
                <%= updatingIngredient != null && updatingIngredient.getIngredient().getId().equals(ingredient.getId())
                        ? "selected" : ""%>>
            <%= ingredient.getName() %>
        </option>
        <%
            }
        %>
    </select>
</div>
</body>
</html>
