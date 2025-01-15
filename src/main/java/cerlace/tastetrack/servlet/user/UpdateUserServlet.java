package cerlace.tastetrack.servlet.user;

import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.service.UserService;
import cerlace.tastetrack.service.impl.UserServiceImpl;
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

@WebServlet(name = "updateUserServlet", value = "/update-user")
public class UpdateUserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = RequestMapperUtil.getLongParam(req, ServletConstants.USER_ID_PARAM);
        UserDTO userDTO = userService.get(id);
        req.setAttribute(ServletConstants.USER_ATTRIBUTE, userDTO);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.USER_UPDATE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        userService.update(
                RequestMapperUtil.getLongParam(req, ServletConstants.USER_ID_PARAM),
                RequestMapperUtil.getDTO(req, UserDTO.class));

        resp.sendRedirect(ServletConstants.USER_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.userService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
