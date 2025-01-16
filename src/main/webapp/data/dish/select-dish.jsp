<%@ page import="java.util.List" %>
<%@ page import="cerlace.tastetrack.servlet.ServletConstants" %>
<%@ page import="cerlace.tastetrack.dto.MealDTO" %>
<%@ page import="cerlace.tastetrack.dto.DishDTO" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<label>
    <% MealDTO updatingMeal = (MealDTO) request.getAttribute(ServletConstants.MEAL_ATTRIBUTE); %>
    Select dish:
    <select name="<%= ServletConstants.DISH_ID_PARAM %>" required>
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
</label>
</body>
</html>
