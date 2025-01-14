package cerlace.tastetrack.servlet.ingredient;

import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.service.IngredientService;
import cerlace.tastetrack.service.impl.IngredientServiceImpl;
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

@WebServlet(name = "selectIngredientServlet", value = "/select-ingredient")
public class SelectIngredientServlet extends HttpServlet {
    private final IngredientService ingredientService = new IngredientServiceImpl();

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        final List<IngredientDTO> ingredientDTOList = this.ingredientService.getAll();

        req.setAttribute(ServletConstants.INGREDIENT_LIST_ATTRIBUTE, ingredientDTOList);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.INGREDIENT_SELECT_JSP);
        requestDispatcher.include(req, resp);
    }

    @Override
    public void destroy() {
        this.ingredientService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
