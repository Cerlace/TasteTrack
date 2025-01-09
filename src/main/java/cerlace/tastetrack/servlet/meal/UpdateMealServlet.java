package cerlace.tastetrack.servlet.meal;

import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.service.MealService;
import cerlace.tastetrack.service.impl.MealServiceImpl;
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

@WebServlet(name = "updateMealServlet", value = "/update-meal")
public class UpdateMealServlet extends HttpServlet {
    private final MealService mealService = new MealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = ServletUtil.getLongParam(req, ServletConstants.MEAL_ID_PARAM);
        MealDTO mealDTO = mealService.get(id);
        req.setAttribute(ServletConstants.MEAL_ATTRIBUTE, mealDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.MEAL_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        mealService.update(
                ServletUtil.getLongParam(req, ServletConstants.MEAL_ID_PARAM),
                ServletUtil.mapMeal(req));

        resp.sendRedirect(ServletConstants.MEAL_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.mealService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
