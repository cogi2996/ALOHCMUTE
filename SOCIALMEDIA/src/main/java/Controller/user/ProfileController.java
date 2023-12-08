package Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import Entity.User;
import Model.UserModel;
import Services.FollowServiceImpl;
import Services.IFollowService;
import Services.IUserService;
import Services.UserServiceImpl;
@WebServlet(urlPatterns = {"/profile","/editProfile"})
public class ProfileController extends HttpServlet{
	IUserService userService = new UserServiceImpl();
	IFollowService followService = new FollowServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("profile")) {
			String uid = req.getParameter("userID");
			User user =  userService.findUser(uid);
			req.setAttribute("user", user );
			HttpSession session = req.getSession();
			String currentUserId = (String) session.getAttribute("uid");
			List<User> listSuggestFollow = followService.suggestFollow(currentUserId);
			req.setAttribute("listSuggestFollow", listSuggestFollow);
			req.getRequestDispatcher("/views/user/profile.jsp").forward(req, resp);
		}
		else if(url.contains("editProfile")){
			HttpSession session = req.getSession();
			String uid = (String) session.getAttribute("uid");
			User user =  userService.findUser(uid);
			req.setAttribute("user", user );
			req.getRequestDispatcher("/views/user/editProfile.jsp").forward(req, resp);
		}
		
		
	}
	
}
