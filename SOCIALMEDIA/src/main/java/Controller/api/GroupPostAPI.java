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

import Entity.Group;
import Entity.User;
import Entity.UserPost;
import Model.GroupPostModel;
import Model.UserPostModel;
import Services.IUserPostService;
import Services.IUserService;
import Services.UserPostServiceImpl;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = { "/api/v1/groupposts/loadAjaxGroupPost", "/api/v1/groupposts", "/api/v1/groupposts/loadMoreGroupPost",
"/api/v1/likegroupPost" })
public class GroupPostAPI  extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	IUserPostService userPostService = new UserPostServiceImpl();

	// CRUD
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("loadAjaxGroupPost")) {
			grouppostLoadAjax(req, resp);
		} else if (url.contains("loadMoreGroupPost")) {
			loadMoreGroupPost(req, resp);
		} else if (url.contains("likegroupPost")) {
			likegroupPost(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("groupposts")) {
			creategroupPost(req, resp);
		}

	}

	// các method
	public void grouppostLoadAjax(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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
		GroupPostModel newgroupPost = gson.fromJson(req.getReader(), GroupPostModel.class);
		System.out.println("userpost da PUT: " + newgroupPost);
		UserPost groupPost = new UserPost();
		groupPost.setUserPostID(newgroupPost.getPostid());
		groupPost.setUserPostText(newgroupPost.getText());
		groupPost.setUserPostCreateTime(newgroupPost.getCreateTime());
		//groupPost.setUserPostUpdateTime(newgroupPost.getUpdateTime());
		groupPost.setUserPostUpdateTime(new Date());
		User user = new User();
		user.setUserID(newgroupPost.getUserid());
		groupPost.setUser(user);
		Group group = new Group();
		group.setGroupID(newgroupPost.getGroupID());
		groupPost.setGroup(group);
		// còn thiếu dữ liệu hình ảnh
		groupPost.setUserPostImg(newgroupPost.getImg());
		userPostService.update(groupPost);
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
		//UserPost userPostJSon = gson.fromJson(req.getReader(), UserPost.class);
		GroupPostModel groupPost = gson.fromJson(req.getReader(), GroupPostModel.class);
		//userPostService.delete(userPostJSon.getUserPostID());
		userPostService.delete(groupPost.getPostid());
		// Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã xóa thành công");
		out.close();
	}
	// hieu-end

	// tuan-begin
	public void loadMoreGroupPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
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

	public void creategroupPost(HttpServletRequest req, HttpServletResponse resp)
			throws JsonSyntaxException, JsonIOException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		//UserPostModel newPost = gson.fromJson(req.getReader(), UserPostModel.class);
		GroupPostModel newgroupPost = gson.fromJson(req.getReader(), GroupPostModel.class);
		System.out.println("grouppost da post: " + newgroupPost);
		UserPost groupPost = new UserPost();
		groupPost.setUserPostText(newgroupPost.getText());
		groupPost.setUserPostCreateTime(new Date());
		User user = new User();
		user.setUserID(newgroupPost.getUserid());
		groupPost.setUser(user);
		Group group = new Group();
		group.setGroupID(newgroupPost.getGroupID());
		groupPost.setGroup(group);
		// còn thiếu dữ liệu hình ảnh
		groupPost.setUserPostImg(newgroupPost.getImg());
		userPostService.insert(groupPost);
		PrintWriter out = resp.getWriter();
		out.println("Đã thêm group post thành công");
		out.close();
	}

	// tuan-end
	public void likegroupPost(HttpServletRequest req, HttpServletResponse resp)
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
