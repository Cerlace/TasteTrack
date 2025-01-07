package cerlace.tastetrack.servlet.userdetails;

import cerlace.tastetrack.service.UserDetailsService;
import cerlace.tastetrack.service.impl.UserDetailsServiceImpl;
import cerlace.tastetrack.servlet.ServletConstants;
import cerlace.tastetrack.utils.HibernateUtil;
import cerlace.tastetrack.utils.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteUserDetailsServlet", value = "/delete-user-details")
public class DeleteUserDetailsServlet extends HttpServlet {
    private final UserDetailsService userDetailsService = new UserDetailsServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.userDetailsService.delete(
                ServletUtil.getLongParam(req, ServletConstants.USER_DETAILS_ID_PARAM));
        resp.sendRedirect(ServletConstants.USER_DETAILS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.userDetailsService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
