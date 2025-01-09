package cerlace.tastetrack.servlet.dish;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.service.DishService;
import cerlace.tastetrack.service.impl.DishServiceImpl;
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

@WebServlet(name = "updateDishServlet", value = "/update-dish")
public class UpdateDishServlet extends HttpServlet {
    private final DishService dishService = new DishServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = ServletUtil.getLongParam(req, ServletConstants.DISH_ID_PARAM);
        DishDTO dishDTO = dishService.get(id);
        req.setAttribute(ServletConstants.DISH_ATTRIBUTE, dishDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.DISH_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        dishService.update(
                ServletUtil.getLongParam(req, ServletConstants.DISH_ID_PARAM),
                ServletUtil.mapDish(req));

        resp.sendRedirect(ServletConstants.DISH_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.dishService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
