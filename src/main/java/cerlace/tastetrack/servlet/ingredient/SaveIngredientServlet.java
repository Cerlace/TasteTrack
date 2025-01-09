package cerlace.tastetrack.servlet.ingredient;

import cerlace.tastetrack.service.IngredientService;
import cerlace.tastetrack.service.impl.IngredientServiceImpl;
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

@WebServlet(name = "saveIngredientServlet", value = "/save-ingredient")
public class SaveIngredientServlet extends HttpServlet {
    private final IngredientService ingredientService = new IngredientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.INGREDIENT_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ingredientService.save(ServletUtil.mapIngredient(req));

        resp.sendRedirect(ServletConstants.INGREDIENT_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.ingredientService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
