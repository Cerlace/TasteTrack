package cerlace.tastetrack.servlet.userdetails;

import cerlace.tastetrack.dto.UserDetailsDTO;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listUserDetailsServlet", value = "/list-user-details")
public class ListUserDetailsServlet extends HttpServlet {
    private final UserDetailsService userDetailsService = new UserDetailsServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<UserDetailsDTO> userDetailsDTOListDTOList = this.userDetailsService.getAll();

        req.setAttribute(ServletConstants.USER_DETAILS_LIST_ATTRIBUTE, userDetailsDTOListDTOList);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.USER_DETAILS_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<UserDetailsDTO> userDetailsDTOListDTOList = new ArrayList<>();
        userDetailsDTOListDTOList.add(userDetailsService.get(
                ServletUtil.getLongParam(req, ServletConstants.USER_DETAILS_ID_PARAM)));

        req.setAttribute(ServletConstants.USER_DETAILS_LIST_ATTRIBUTE, userDetailsDTOListDTOList);

        RequestDispatcher requestDispatcher = getServletContext()
                .getRequestDispatcher(ServletConstants.USER_DETAILS_LIST_JSP);
        requestDispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        this.userDetailsService.closeDao();
        HibernateUtil.close();
        super.destroy();
    }
}
