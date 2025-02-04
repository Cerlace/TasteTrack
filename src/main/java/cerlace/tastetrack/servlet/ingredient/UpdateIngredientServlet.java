package cerlace.tastetrack.servlet.ingredient;

import cerlace.tastetrack.dto.IngredientDTO;
import cerlace.tastetrack.service.IngredientService;
import cerlace.tastetrack.service.impl.IngredientServiceImpl;
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

@WebServlet(name = "updateIngredientServlet", value = "/update-ingredient")
public class UpdateIngredientServlet extends HttpServlet {
    private final IngredientService ingredientService = new IngredientServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = RequestMapperUtil.getLongParam(req, ServletConstants.INGREDIENT_ID_PARAM);
        IngredientDTO ingredientDTO = ingredientService.get(id);
        req.setAttribute(ServletConstants.INGREDIENT_ATTRIBUTE, ingredientDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.INGREDIENT_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletUtil.handleAppExceptions(req, () ->
                    ingredientService.update(
                            RequestMapperUtil.getLongParam(req, ServletConstants.INGREDIENT_ID_PARAM),
                            RequestMapperUtil.getDTO(req, IngredientDTO.class))
        );
        resp.sendRedirect(ServletConstants.INGREDIENT_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        ingredientService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
