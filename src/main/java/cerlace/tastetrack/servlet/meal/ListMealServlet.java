package cerlace.tastetrack.servlet.meal;

import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.service.MealService;
import cerlace.tastetrack.service.impl.MealServiceImpl;
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

@WebServlet(name = "listMealServlet", value = "/list-meal")
public class ListMealServlet extends HttpServlet {
    private final MealService mealService = new MealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<MealDTO> mealDTOList = this.mealService.getAll();

        req.setAttribute(ServletConstants.MEAL_LIST_ATTRIBUTE, mealDTOList);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.MEAL_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.mealService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
