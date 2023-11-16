package Controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import Entity.UserPost;
import Services.IUserPostService;
import Services.IUserService;
import Services.UserPostServiceImpl;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = { "/home", "/follower", "/home/loadAjaxPost" })
public class Home extends HttpServlet {

	// test
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IUserPostService userPostService = new UserPostServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("loadAjaxPost")) {
			postLoadAjax(req, resp);
		} else if (url.contains("home")) {
			req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);

		} else if (url.contains("follower")) {
			findFollowersByUserId(req, resp);
		}

		else if (url.contains("TEST")) {
			System.out.println("test success");
		}
	}

	// tuan
	public void postLoadAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String amount = req.getParameter("exits");
		int imount = Integer.parseInt(amount);
		List<UserPost> listPost =  userPostService.paginationPage(imount, 6);
		PrintWriter out = resp.getWriter();
//		out.println("<h1>SUCCESS</h1>");

	}

	// hieu
	private void findFollowersByUserId(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.findUser(id);
		List<User> followers = user.getFollowers();
		req.setAttribute("listfollower", followers);

		RequestDispatcher rd = req.getRequestDispatcher("/views/user/followers.jsp");
		rd.forward(req, resp);

	}
}
