package cerlace.tastetrack.servlet.user;

import cerlace.tastetrack.dto.UserDTO;
import cerlace.tastetrack.service.UserService;
import cerlace.tastetrack.service.impl.UserServiceImpl;
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

@WebServlet(name = "listUserServlet", value = "/list-user")
public class ListUserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<UserDTO> userDTOList = this.userService.getAll();

        req.setAttribute(ServletConstants.USER_LIST_ATTRIBUTE, userDTOList);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.USER_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.userService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
