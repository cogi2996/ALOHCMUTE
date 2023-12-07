package Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Services.IUserPostService;
import Services.IUserService;
import Services.UserPostServiceImpl;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = { "/home", "/follower" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IUserPostService userPostService = new UserPostServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}


}
