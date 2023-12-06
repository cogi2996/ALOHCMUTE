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

import com.google.gson.Gson;

import Entity.User;
import Entity.UserPost;
import Model.UserModel;
import Model.UserPostModel;
import Services.IUserService;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = { "/api/v1/follower", "/api/v1/following","/api/v1" })
public class userAPI extends HttpServlet {
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("follower")) {
			listfollower(req, resp);
		} else if (url.contains("following")) {
			listfollowing(req, resp);
		}
	}

	// người dùng đang follow người khác
	private void listfollowing(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String userID = req.getParameter("userID");
		// String userID = "user1";
		User user = userService.findUser(userID);
		List<User> listfollowing = user.getFollowingUsers();
		List<UserModel> listfollowingModel = new ArrayList<UserModel>();
		for (User userfollowing : listfollowing) {

			String mobile = userfollowing.getMobile();
			String firstName = userfollowing.getFirstName();
			String midName = userfollowing.getMidName();
			String lastName = userfollowing.getLastName();
			String address = userfollowing.getAddress();
			String position = userfollowing.getPosition();
			String workPlace = userfollowing.getWorkPlace();

			UserModel userModel = new UserModel(mobile, firstName, midName, lastName, address, position,workPlace);
			listfollowingModel.add(userModel);
		}

		Gson gson = new Gson();
		String json = gson.toJson(listfollowingModel);
		PrintWriter pw = resp.getWriter();
		pw.write(json);
		pw.close();

	}
	// người dùng được người khác follow
	private void listfollower(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String userID = req.getParameter("userID");
		// String userID = "user1";
		User user = userService.findUser(userID);
		List<User> listfollower = user.getFollowers();
		List<UserModel> listfollowerModel = new ArrayList<UserModel>();
		for (User userfollow : listfollower) {

			String mobile = userfollow.getMobile();
			String firstName = userfollow.getFirstName();
			String midName = userfollow.getMidName();
			String lastName = userfollow.getLastName();
			String address = userfollow.getAddress();
			String position = userfollow.getPosition();
			String workPlace = userfollow.getWorkPlace();

			UserModel userModel = new UserModel(mobile, firstName, midName, lastName, address, position,workPlace);
			listfollowerModel.add(userModel);
		}

		Gson gson = new Gson();
		String json = gson.toJson(listfollowerModel);
		PrintWriter pw = resp.getWriter();
		pw.write(json);
		pw.close();
	}
	// sửa thông tin của 1 user
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		UserModel usermodel = gson.fromJson(req.getReader(),UserModel.class);
		User updatedUser = new User();
		
		updatedUser = userService.findUser(usermodel.getUserID());
		System.out.println(updatedUser);
		updatedUser.setMobile(usermodel.getMobile());
		updatedUser.setFirstName(usermodel.getFirstName());
		updatedUser.setMidName(usermodel.getMidName());
		updatedUser.setLastName(usermodel.getLastName());
		updatedUser.setAddress(usermodel.getAddress());
		updatedUser.setBiography(usermodel.getBiography());
		updatedUser.setPosition(usermodel.getPosition());
		updatedUser.setWorkPlace(usermodel.getWorkPlace());
		updatedUser.setAvatar(usermodel.getAvatar());
		updatedUser.setUserID(usermodel.getUserID());
		
		userService.update(updatedUser);
		// Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã sửa thông tin user thành công");
		out.close();
	}
	
}
