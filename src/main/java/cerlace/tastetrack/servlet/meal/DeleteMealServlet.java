package cerlace.tastetrack.servlet.meal;

import cerlace.tastetrack.service.MealService;
import cerlace.tastetrack.service.impl.MealServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteMealServlet", value = "/delete-meal")
public class DeleteMealServlet extends HttpServlet {
    private final MealService mealService = new MealServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.mealService.delete(
                RequestMapperUtil.getLongParam(req, ServletConstants.MEAL_ID_PARAM));
        resp.sendRedirect(ServletConstants.MEAL_LIST_SERVLET +
                "?" + ServletConstants.USER_ID_PARAM +
                "=" + req.getParameter(ServletConstants.USER_ID_PARAM));
    }

    @Override
    public void destroy() {
        this.mealService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
