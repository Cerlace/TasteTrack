package cerlace.tastetrack.servlet.dishingredient;

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

@WebServlet(name = "saveDishIngredientServlet", value = "/save-dish-ingredient")
public class SaveDishIngredientServlet extends HttpServlet {
    private final DishIngredientService dishIngredientService = new DishIngredientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.DISH_INGREDIENT_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dishIngredientService.save(ServletUtil.mapDishIngredient(req));

        resp.sendRedirect(ServletConstants.DISH_INGREDIENT_LIST_SERVLET +
                "?" + ServletConstants.DISH_ID_PARAM +
                "=" + req.getParameter(ServletConstants.DISH_ID_PARAM));
    }

    @Override
    public void destroy() {
        this.dishIngredientService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
