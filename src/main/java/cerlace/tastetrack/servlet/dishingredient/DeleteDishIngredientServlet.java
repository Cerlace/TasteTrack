package cerlace.tastetrack.servlet.dishingredient;

import cerlace.tastetrack.service.DishIngredientService;
import cerlace.tastetrack.service.impl.DishIngredientServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.RequestMapperUtil;
import cerlace.tastetrack.utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteDishIngredientServlet", value = "/delete-dish-ingredient")
public class DeleteDishIngredientServlet extends HttpServlet {
    private final DishIngredientService dishIngredientService = new DishIngredientServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletUtil.handleAppExceptions(req, () ->
                dishIngredientService.delete(
                        RequestMapperUtil.getLongParam(req, ServletConstants.DISH_INGREDIENT_ID_PARAM))
        );
        resp.sendRedirect(ServletConstants.DISH_INGREDIENT_LIST_SERVLET +
                "?" + ServletConstants.DISH_ID_PARAM +
                "=" + req.getParameter(ServletConstants.DISH_ID_PARAM));
    }

    @Override
    public void destroy() {
        dishIngredientService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
