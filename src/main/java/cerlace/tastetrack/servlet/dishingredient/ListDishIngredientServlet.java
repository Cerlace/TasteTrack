package cerlace.tastetrack.servlet.dishingredient;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.service.DishIngredientService;
import cerlace.tastetrack.service.impl.DishIngredientServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "listDishIngredientServlet", value = "/list-dish-ingredient")
public class ListDishIngredientServlet extends HttpServlet {
    private final DishIngredientService dishIngredientService = new DishIngredientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long dishId = ServletUtil.getLongParam(req, ServletConstants.DISH_ID_PARAM);

        final List<DishIngredientDTO> dishIngredientDTOList =
                this.dishIngredientService.getAllIngredientsOfDish(dishId);

        req.setAttribute(ServletConstants.DISH_INGREDIENT_LIST_ATTRIBUTE, dishIngredientDTOList);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.DISH_INGREDIENT_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.dishIngredientService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
