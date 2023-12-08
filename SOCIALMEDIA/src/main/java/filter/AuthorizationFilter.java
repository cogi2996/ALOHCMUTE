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


// filter authen
@WebFilter(urlPatterns = "/*")
public class AuthorizationFilter implements Filter {
	

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		boolean loggedIn = (session != null && session.getAttribute("uid") != null);
		String logginUrl = req.getContextPath() + "/dangnhap";
		// nếu người dùng hiện tại chưa đăng nhập && ở một trang khác trang đặng nhập
		// thì chuyễn về trang đăng nhập
		// Cho phép truy cập vào các tệp trong đường dẫn /templates/ mà không cần đăng
		// nhập

		if (req.getServletPath().contains("/templates/firebase/firebase.js")
				|| req.getServletPath().contains("/templates/login/script/login.js")) {
			chain.doFilter(request, response);
			return;
		} 
		// nếu tài khoản chưa đăng nhập && vào trang đăng kí
		else if (req.getServletPath().contains("/dangki")) {
			chain.doFilter(request, response);
			return;
		}
		if (!loggedIn && !req.getRequestURI().equals(logginUrl)) {
			resp.sendRedirect(logginUrl);
			return;
		}
		chain.doFilter(request, response);
	}

}
