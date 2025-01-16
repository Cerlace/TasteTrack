package cerlace.tastetrack.servlet.dish;

import cerlace.tastetrack.dto.DishDTO;
import cerlace.tastetrack.service.DishService;
import cerlace.tastetrack.service.impl.DishServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "selectDishServlet", value = "/select-dish")
public class SelectDishServlet extends HttpServlet {
    private final DishService dishService = new DishServiceImpl();

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final List<DishDTO> dishDTOList = this.dishService.getAll();

        req.setAttribute(ServletConstants.DISH_LIST_ATTRIBUTE, dishDTOList);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.DISH_SELECT_JSP);
        requestDispatcher.include(req, resp);
    }

    @Override
    public void destroy() {
        this.dishService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
