package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        boolean loggedIn = (session != null && session.getAttribute("uid") != null);
        String loginUrl = req.getContextPath() + "/dangnhap";

        // Check for admin pages
        if (req.getServletPath().startsWith("/admin")) {
            if (!loggedIn || (session.getAttribute("role") == null || (int) session.getAttribute("role") != 1)) {
                resp.sendRedirect(loginUrl);
                return;
            }
        }

        // Check for permitted resources
        if (isPermittedResource(req)) {
            chain.doFilter(request, response);
            return;
        }

        // Redirect to login if not logged in and not accessing permitted resources
        if (!loggedIn && !req.getRequestURI().equals(loginUrl)) {
            resp.sendRedirect(loginUrl);
            return;
        }

        chain.doFilter(request, response);
    }

    // Method to determine permitted resources
    private boolean isPermittedResource(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        return servletPath.contains("/templates/firebase/firebase.js")
                || servletPath.contains("/templates/login/script/login.js")
                || servletPath.contains("forgotPassword")
                || servletPath.contains("identitytoolkit")
                || servletPath.contains("/dangki"); // Add more if needed
    }

    // Other methods (init, destroy) can remain unchanged
}
