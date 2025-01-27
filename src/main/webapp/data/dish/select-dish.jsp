<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.MealDTO" %>
<%@ page import="cerlace.tastetrack.dto.DishDTO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<% MealDTO updatingMeal = (MealDTO) request.getAttribute(ServletConstants.MEAL_ATTRIBUTE); %>
<div class="input-group">
    <label for="dish-select">
        Select dish:
    </label>
    <select id="dish-select"
            name="<%= ServletConstants.DISH_ID_PARAM %>" required>
        <% List<DishDTO> dishes = (List<DishDTO>) request.getAttribute(ServletConstants.DISH_LIST_ATTRIBUTE);
            for (DishDTO dish : dishes) {
        %>
        <option value="<%= dish.getId() %>"
                <%= updatingMeal != null && updatingMeal.getDish().getId().equals(dish.getId())
                        ? "selected" : ""%>>
            <%= dish.getName() %>
        </option>
        <%
            }
        %>
    </select>
</div>
</body>
</html>
