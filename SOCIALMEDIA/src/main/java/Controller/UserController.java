package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SiteController
 */
@WebServlet({ "/follower", "/hiring" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		if (url.contains("follower")) {
			findFollowersByUserId(request, response);
		} else if (url.contains("hiring")) {
			getAllHiringPost(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void findFollowersByUserId(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// chưa có db nên k get lên được
		// int id = Integer.parseInt(req.getParameter("id"));
		// User user = userService.findUser(id);
		// List<User> followers = user.getFollowers();
		// req.setAttribute("listfollower", followers);

		RequestDispatcher rd = request.getRequestDispatcher("/views/user/follower.jsp");
		rd.forward(request, response);
	}

	// Get tin tuyển dụng không biết nên dặt servlet nào vì chưa có db - Hoàng
	private void getAllHiringPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// chưa có db nên chưa biết get sao
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/hiring.jsp");
		rd.forward(request, response);
	}
}
