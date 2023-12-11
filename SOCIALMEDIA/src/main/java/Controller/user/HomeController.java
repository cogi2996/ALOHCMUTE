package Controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Dao.IFollowDAO;
import Entity.User;
import Entity.UserPost;
import Model.UserPostModel;
import Services.FollowServiceImpl;
import Services.IFollowService;
import Services.IUserPostService;
import Services.IUserService;
import Services.UserPostServiceImpl;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = { "/home", "/timkiem/follower", "/deletefollower" })
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IUserPostService userPostService = new UserPostServiceImpl();
	IFollowService followService = new FollowServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
//		if (url.contains("loadAjaxPost")) {
//			postLoadAjax(req, resp);
//		} else 
		if (url.contains("home")) {
			HttpSession session = req.getSession();
			String uid = (String) session.getAttribute("uid");
			User user = userService.findUser(uid);
			List<User> listSuggestFollow = followService.suggestFollow(uid);
			List<UserPost> listImgPost = userPostService.findAllImg(uid);
			req.setAttribute("listSuggestFollow", listSuggestFollow);
			req.setAttribute("currentUser", user);
			req.setAttribute("listImgPost", listImgPost);
			req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
			
		} else if (url.contains("follower")) {
			findFollowersByUserId(req, resp);
		}
		else if(url.contains("deletefollower"))
		{
			HttpSession session = req.getSession();
			String uid = (String) session.getAttribute("uid");
			String sourceID = req.getParameter("id");
			System.out.println("Source" + sourceID);
			System.out.println("Taget" + uid);
			followService.delete(sourceID, uid);
			RequestDispatcher rd = req.getRequestDispatcher("follower");
			rd.forward(req, resp);
		}
	}

	// tuan
//	public void postLoadAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		resp.setContentType("application/json");
//		resp.setCharacterEncoding("UTF-8");
//		String amount = req.getParameter("exits");
//		int imount = Integer.parseInt(amount);
//		List<UserPost> listPost = userPostService.paginationPage(imount, 6);
//		List<UserPostModel> listPostModel = new ArrayList<UserPostModel>();
//		for (UserPost post : listPost) {
//			String username = post.getUser().getLastName() + ' ' + post.getUser().getMidName() + ' '
//					+ post.getUser().getFirstName();
//			String userid = post.getUser().getUserID();
//			int postid = post.getUserPostID();
//			String text = post.getUserPostText();
//			Date createTime = post.getUserPostCreateTime();
//			String img = post.getUserPostImg();
//			UserPostModel postModel = new UserPostModel(username, userid, postid, text, createTime, img);
//			listPostModel.add(postModel);
//		}
//		Gson gson = new Gson();
//		String listPostJson = gson.toJson(listPostModel);
//		System.out.println("list post lay duoc ; " + listPostModel);
//		PrintWriter out = resp.getWriter();
//		out.println(listPostJson);
//		out.close();
//	}

	// hieu
	private void findFollowersByUserId(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		User user = userService.findUser(uid);
		List<User> followers = user.getFollowers();
		req.setAttribute("listfollower", followers);

		RequestDispatcher rd = req.getRequestDispatcher("/views/user/follower.jsp");
		rd.forward(req, resp);

	}
	//	KUyTipGNpdVhNj2iLWUuDhqTzmB2	0348083543	2023-12-09 00:00:00		Hạ	Nhật	Võ	Hà Nội	time to rise	Công nghệ thông tin	Khoa  công nghệ thông tin		0
}
