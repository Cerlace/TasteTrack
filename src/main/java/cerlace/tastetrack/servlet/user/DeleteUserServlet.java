package cerlace.tastetrack.servlet.user;

import cerlace.tastetrack.service.UserService;
import cerlace.tastetrack.service.impl.UserServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.RequestMapperUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUserServlet", value = "/delete-user")
public class DeleteUserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.userService.delete(
                RequestMapperUtil.getLongParam(req, ServletConstants.USER_ID_PARAM));
        resp.sendRedirect(ServletConstants.USER_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.userService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
