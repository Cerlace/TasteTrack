package cerlace.tastetrack.filter;

import cerlace.tastetrack.servlet.ServletConstants;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;

@WebFilter(filterName = "LocaleFilter", urlPatterns = {"/*"})
public class LocaleFilter implements Filter {

    public static final int DAYS_TO_STORE_COOKIE = 365;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        if (req.getParameter(ServletConstants.COOKIE_LOCALE_PARAM) != null) {
            Cookie cookie = new Cookie(ServletConstants.LOCALE_COOKIE,
                    req.getParameter(ServletConstants.COOKIE_LOCALE_PARAM));
            cookie.setMaxAge((int) Duration.ofDays(DAYS_TO_STORE_COOKIE).getSeconds());
            cookie.setPath("/");
            resp.addCookie(cookie);
            resp.sendRedirect(req.getRequestURI());
        } else {
            chain.doFilter(request, response);
        }
    }
}
