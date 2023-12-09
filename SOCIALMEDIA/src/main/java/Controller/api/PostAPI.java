package Controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
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

import com.google.api.client.util.DateTime;
import com.google.gson.Gson;

import Entity.User;
import Entity.UserPost;
import Model.UserPostModel;
import Services.IUserPostService;
import Services.IUserService;
import Services.UserPostServiceImpl;
import Services.UserServiceImpl;
@WebServlet(urlPatterns = {"/api/v1/posts/loadAjaxPost","/api/v1/posts", "/api/v1/listUserLike", "/api/v1/like"})

public class PostAPI extends HttpServlet{
	IUserService userService = new UserServiceImpl();
	IUserPostService userPostService = new UserPostServiceImpl();
	// CRUD
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("loadAjaxPost")) {
			postLoadAjax(req, resp);
		}
//		if(url.contains("listUserLike")) //lay danh sach user like post 
//		{
//			int id = Integer.parseInt(req.getParameter("id"));
//			LikeUserPost likePost = userPostService.findLikeUserPost(id);
//			List<User> userLikePost = likePost.getUser();
//			Long countLike = userPostService.countLike(id); //dem user like post
//			
//			
//			req.setAttribute("listUser", userLikePost);
//			req.setAttribute("countLike", countLike);
//			
//			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listuser.jsp");
//			rd.forward(req, resp);
//		}
//		if(url.contains("unlike")) //user huy like
//		{
//			delete(req, resp);
//		}
//	}
//	private void delete(HttpServletRequest req, HttpServletResponse resp) {
//		int id = Integer.parseInt(req.getParameter("id"));
//		HttpSession session = req.getSession(true);
//		
//        // Lấy userID từ thuộc tính của phiên.
//        String userID = (String) session.getAttribute("userID");
//        userPostService.deleteUserLike(userID, id);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		UserPostModel newPost = gson.fromJson(req.getReader(),UserPostModel.class);
		System.out.println("userpost da post: "+ newPost);
		UserPost userPost = new UserPost();
		userPost.setUserPostText(newPost.getText());
		userPost.setUserPostCreateTime(new Date());
		User user = new User();
		user.setUserID(newPost.getUserid());
		userPost.setUser(user);
		// còn thiếu dữ liệu hình ảnh 
		userPost.setUserPostImg(newPost.getImg());
		userPostService.insert(userPost);
		
		//hieu them
//		String url = req.getRequestURL().toString();
//		if (url.contains("like")) //user like
//		{
//			insertLikePost(req, resp);
//		}
	}

//	private void insertLikePost(HttpServletRequest req, HttpServletResponse resp) throws IOException{
//		int id = Integer.parseInt(req.getParameter("id"));
//		LikeUserPost model = userPostService.findLikeUserPost(id);
//		try {
//			model.setUserPostID(id);
//			HttpSession session = req.getSession(true);
//	
//	        // Lấy userID từ thuộc tính của phiên.
//	        String userID = (String) session.getAttribute("userID");
//			User user = new User();
//			user.setUserID(userID);
//			long millis=System.currentTimeMillis();   
//			Date date= new java.sql.Date(millis);
//			model.setLikeTime(date);
//			
//			userPostService.insertUserLikePost(model);
//		} catch (Exception e) {
//			e.printStackTrace();
//			req.setAttribute("error", "Thất bại");
//		}
//	}
	// các method
	public void postLoadAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		String amount = req.getParameter("exits");
		System.out.println("[1]-bat dau load");
		System.out.println(amount);
		System.out.println("[2]-end load");
		int imount = Integer.parseInt(amount);
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		List<UserPost> listPost = userPostService.paginationPostUser(imount, 4,uid);
		List<UserPostModel> listPostModel = new ArrayList<UserPostModel>();
		for (UserPost post : listPost) {
			String username = post.getUser().getLastName() + ' ' + post.getUser().getMidName() + ' '
					+ post.getUser().getFirstName();
			String userid = post.getUser().getUserID();
			int postid = post.getUserPostID();
			String text = post.getUserPostText();
			Date createTime = post.getUserPostCreateTime();
			String img = post.getUserPostImg();
			UserPostModel postModel = new UserPostModel(username, userid, postid, text, createTime, img);
			listPostModel.add(postModel);
		}
		Gson gson = new Gson();
		String listPostJson = gson.toJson(listPostModel);
		System.out.println("list post lay duoc ; " + listPostModel);
		PrintWriter out = resp.getWriter();
		out.println(listPostJson);
		out.close();
	}
	//hieu-begin
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		UserPostModel newPost = gson.fromJson(req.getReader(),UserPostModel.class);
		System.out.println("userpost da PUT: "+ newPost);
		UserPost userPost = new UserPost();
		userPost.setUserPostID(newPost.getPostid());
		userPost.setUserPostText(newPost.getText());
		userPost.setUserPostCreateTime(newPost.getCreateTime());
		userPost.setUserPostUpdateTime(newPost.getUpdateTime());
		User user = new User();
		user.setUserID(newPost.getUserid());
		userPost.setUser(user);
		// còn thiếu dữ liệu hình ảnh 
		userPost.setUserPostImg(newPost.getImg());
		userPostService.update(userPost);
		//Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã sửa thành công");
		out.close();
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("userPostID"));
		System.out.println(id);
		userPostService.delete(id);
		//Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã xóa thành công");
		out.close();
	}
	//hieu-end
}