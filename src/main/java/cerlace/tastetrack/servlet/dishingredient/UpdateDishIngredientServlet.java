package cerlace.tastetrack.servlet.dishingredient;

import cerlace.tastetrack.dto.DishIngredientDTO;
import cerlace.tastetrack.service.DishIngredientService;
import cerlace.tastetrack.service.impl.DishIngredientServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "updateDishIngredientServlet", value = "/update-dish-ingredient")
public class UpdateDishIngredientServlet extends HttpServlet {
    private final DishIngredientService dishIngredientService = new DishIngredientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = RequestMapperUtil.getLongParam(req, ServletConstants.DISH_INGREDIENT_ID_PARAM);
        DishIngredientDTO dishIngredientDTO = dishIngredientService.get(id);
        req.setAttribute(ServletConstants.DISH_INGREDIENT_ATTRIBUTE, dishIngredientDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.DISH_INGREDIENT_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        dishIngredientService.update(
                RequestMapperUtil.getLongParam(req, ServletConstants.DISH_INGREDIENT_ID_PARAM),
                RequestMapperUtil.getDTO(req, DishIngredientDTO.class));

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
