package cerlace.tastetrack.servlet.dish;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.service.DishService;
import cerlace.tastetrack.service.impl.DishServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.RequestMapperUtil;
import cerlace.tastetrack.utils.ServletUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "saveDishServlet", value = "/save-dish")
public class SaveDishServlet extends HttpServlet {
    private final DishService dishService = new DishServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.DISH_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtil.handleAppExceptions(req, () ->
                dishService.save(RequestMapperUtil.getDTO(req, DishDTO.class))
        );
        resp.sendRedirect(ServletConstants.DISH_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        dishService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
