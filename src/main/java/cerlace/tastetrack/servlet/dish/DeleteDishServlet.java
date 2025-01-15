package cerlace.tastetrack.servlet.dish;

import cerlace.tastetrack.service.DishService;
import cerlace.tastetrack.service.impl.DishServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteDishServlet", value = "/delete-dish")
public class DeleteDishServlet extends HttpServlet {
    private final DishService dishService = new DishServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.dishService.delete(
                RequestMapperUtil.getLongParam(req, ServletConstants.DISH_ID_PARAM));
        resp.sendRedirect(ServletConstants.DISH_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.dishService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
