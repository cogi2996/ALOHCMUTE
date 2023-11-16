package Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import Services.IUserService;
import Services.UserServiceImpl;
@WebServlet(urlPatterns = {"/home", "/followers"})
public class Home extends HttpServlet  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("home")) {
			req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
		} else if (url.contains("follower")) {
			findFollowersByUserId(req, resp);
		} 
	}
	private void findFollowersByUserId(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		int id = Integer.parseInt(req.getParameter("id"));
		User user = userService.findUser(id);
		List<User> followers = user.getFollowers();
		for (User follower : followers) {
		    System.out.println(follower);
		}
		req.setAttribute("listfollowers", followers);
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/listfollowers.jsp");
		rd.forward(req, resp);
	}
}	
