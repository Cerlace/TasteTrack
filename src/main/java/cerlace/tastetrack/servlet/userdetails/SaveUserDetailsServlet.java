package cerlace.tastetrack.servlet.userdetails;

import cerlace.tastetrack.service.UserDetailsService;
import cerlace.tastetrack.service.impl.UserDetailsServiceImpl;
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

@WebServlet(name = "saveUserDetailsServlet", value = "/save-user-details")
public class SaveUserDetailsServlet extends HttpServlet {
    private final UserDetailsService userDetailsService = new UserDetailsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.USER_DETAILS_SAVE_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userDetailsService.save(ServletUtil.mapUserDetails(req));

        resp.sendRedirect(ServletConstants.USER_DETAILS_LIST_SERVLET);
    }

    @Override
    public void destroy() {
        this.userDetailsService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
