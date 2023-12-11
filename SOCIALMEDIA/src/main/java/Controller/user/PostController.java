package Controller.user;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import Entity.UserPost;
import Services.IUserPostService;
import Services.UserPostServiceImpl;
@WebServlet(urlPatterns =  "/baiviet")
public class PostController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		int userPostID = Integer.parseInt(req.getParameter("userPostID")) ;
//		int userPostID = 6;
		UserPost post = userPostService.findOne(userPostID);
		User user = post.getUser();
		
		req.setAttribute("post", post);
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/post.jsp");
		rd.forward(req, resp);
	}
	IUserPostService userPostService = new UserPostServiceImpl();
	public UserPost findOnePost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		int userPostID = Integer.parseInt(req.getParameter("userPostID")) ;
		
		UserPost post = userPostService.findOne(userPostID);
		return post;
	}
}
