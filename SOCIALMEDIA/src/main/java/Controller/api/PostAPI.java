package Controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import Entity.User;
import Entity.UserPost;
import Model.UserPostModel;
import Services.IUserPostService;
import Services.IUserService;
import Services.UserPostServiceImpl;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = { "/api/v1/posts/loadAjaxPost", "/api/v1/posts", "/api/v1/posts/loadMoreUserPost",
		"/api/v1/likePost" })

public class PostAPI extends HttpServlet {
	IUserService userService = new UserServiceImpl();
	IUserPostService userPostService = new UserPostServiceImpl();

	// CRUD
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("loadAjaxPost")) {
			postLoadAjax(req, resp);
		} else if (url.contains("loadMoreUserPost")) {
			loadMoreUserPost(req, resp);
		} else if (url.contains("likePost")) {
			likePost(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("posts")) {
			createPost(req, resp);
		}

	}

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
		List<UserPost> listPost = userPostService.paginationPostUser(imount, 4, uid);
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

	// hieu-begin
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		UserPostModel newPost = gson.fromJson(req.getReader(), UserPostModel.class);
		System.out.println("userpost da PUT: " + newPost);
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
		// Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã sửa thành công");
		out.close();
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		UserPost userPostJSon = gson.fromJson(req.getReader(), UserPost.class);
		userPostService.delete(userPostJSon.getUserPostID());
		// Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã xóa thành công");
		out.close();
	}
	// hieu-end

	// tuan-begin
	public void loadMoreUserPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		String amount = req.getParameter("exits");
		System.out.println("[1]-bat dau load");
		System.out.println(amount);
		int imount = Integer.parseInt(amount);
//		HttpSession session = req.getSession();
//		String uid = (String) session.getAttribute("uid");
		String uid = req.getParameter("uid");
		System.out.println(uid);
		System.out.println("[2]-end load");
		List<UserPost> listPost = userPostService.paginationPostProfile(imount, 4, uid);
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

	public void createPost(HttpServletRequest req, HttpServletResponse resp)
			throws JsonSyntaxException, JsonIOException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		UserPostModel newPost = gson.fromJson(req.getReader(), UserPostModel.class);
		System.out.println("userpost da post: " + newPost);
		UserPost userPost = new UserPost();
		userPost.setUserPostText(newPost.getText());
		userPost.setUserPostCreateTime(new Date());
		User user = new User();
		user.setUserID(newPost.getUserid());
		userPost.setUser(user);
		// còn thiếu dữ liệu hình ảnh
		userPost.setUserPostImg(newPost.getImg());
		userPostService.insert(userPost);
	}

	// tuan-end
	public void likePost(HttpServletRequest req, HttpServletResponse resp)
			throws JsonSyntaxException, JsonIOException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		// lấy ra uid người like
		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		int postId = Integer.parseInt(req.getParameter("postId"));
		System.out.println("da vao likepost");
//		int postId = gson.fromJson(req.getReader(), int.class);
		userPostService.insertLikePost(uid, postId, null);
		// trả về số like hiện tại
		Gson gson = new Gson();
		String countLike = gson.toJson(userPostService.findOne(postId).getLikeUsers().size());
		PrintWriter out = resp.getWriter();
		out.println(countLike);
		out.close();
	}

	// tuan - begin - api like post

	// tuan - end

}