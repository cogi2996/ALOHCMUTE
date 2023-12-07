package Controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import Entity.User;
import Services.IUserPostService;
import Services.IUserService;
import Services.UserPostServiceImpl;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = { "/home", "/follower", "/search", "/editUser" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IUserPostService userPostService = new UserPostServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("home")) {
			req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
		}
		if (url.contains("search")) {
			String keyword = req.getParameter("keyword");
			List<User> listuser = userService.searchUsersByKeyword(keyword);
			req.setAttribute("listuser", listuser);
			System.out.println(listuser);
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/searchUser.jsp");
			rd.forward(req, resp);
		}
		if (url.contains("editUser")) {
			String userID = req.getParameter("userID");
			User user = userService.findUser(userID);
			req.setAttribute("user", user);
			System.out.println(user);
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/editUser.jsp");
			rd.forward(req, resp);
			
		}
	}

}