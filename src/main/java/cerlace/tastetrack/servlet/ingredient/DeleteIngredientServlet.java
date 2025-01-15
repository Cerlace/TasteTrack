package cerlace.tastetrack.servlet.ingredient;

import cerlace.tastetrack.service.IngredientService;
import cerlace.tastetrack.service.impl.IngredientServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteIngredientServlet", value = "/delete-ingredient")
public class DeleteIngredientServlet extends HttpServlet {
    private final IngredientService ingredientService = new IngredientServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.ingredientService.delete(
                RequestMapperUtil.getLongParam(req, ServletConstants.INGREDIENT_ID_PARAM));
        resp.sendRedirect(ServletConstants.INGREDIENT_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.ingredientService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
