package cerlace.tastetrack.servlet.meal;

import cerlace.tastetrack.dto.MealDTO;
import cerlace.tastetrack.service.MealService;
import cerlace.tastetrack.service.impl.MealServiceImpl;
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

@WebServlet(name = "saveMealServlet", value = "/save-meal")
public class SaveMealServlet extends HttpServlet {
    private final MealService mealService = new MealServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.MEAL_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        mealService.save(RequestMapperUtil.getDTO(req, MealDTO.class));

        resp.sendRedirect(ServletConstants.MEAL_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.mealService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
