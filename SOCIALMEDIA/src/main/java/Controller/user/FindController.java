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
@WebServlet(urlPatterns = {"/timkiem"})
public class FindController extends HttpServlet{
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String keyword= req.getParameter("keyword");
//		List<User> listuser = userService.searchUsersByKeyword(keyword);
//		req.setAttribute("listuser", listuser);
//		System.out.println(listuser);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/resultFind.jsp");
		rd.forward(req, resp);
	}
}
