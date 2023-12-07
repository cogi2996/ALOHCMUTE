package Controller.api;

import java.io.IOException;
import java.util.Date;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Entity.User;
import Model.UserModel;
import Services.IUserService;
import Services.UserServiceImpl;
import Entity.Follow;
import Services.FollowServiceImpl;
import Services.IFollowService;

@WebServlet(urlPatterns = { "/api/v1/userFollow", "/api/v1/follower", "/api/v1/following", "/api/v1/searchUser","/api/v1/informationUser", "/api/v1/user" })
public class userAPI extends HttpServlet {
	IUserService userService = new UserServiceImpl();
	IFollowService followService = new FollowServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("follower")) {
			listfollower(req, resp);
		} else if (url.contains("following")) {
			listfollowing(req, resp);
		} else if (url.contains("userFollow")) {
			String sourceID = req.getParameter("sourceID");
			String targetID = req.getParameter("targetID");
			System.out.println(sourceID);
			Follow newFollow = new Follow(sourceID, targetID, new Date());
			followService.insert(newFollow);
		} else if (url.contains("searchUser")) {
			searchUsers(req, resp);
		} else if (url.contains("informationUser")) {
			informationUser(req, resp);
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

			UserModel userModel = new UserModel(mobile, firstName, midName, lastName, address, position, workPlace);
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

			UserModel userModel = new UserModel(mobile, firstName, midName, lastName, address, position, workPlace);
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
		UserModel usermodel = gson.fromJson(req.getReader(), UserModel.class);
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

	private void searchUsers(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String keyword = req.getParameter("keyword");
		List<User> user = userService.searchUsersByKeyword(keyword);
		List<UserModel> listuser = new ArrayList<UserModel>();
		for (User usersearch : user) {
			String firstName = usersearch.getFirstName();
			String midName = usersearch.getMidName();
			String lastName = usersearch.getLastName();
			UserModel userModel = new UserModel(firstName, midName, lastName);
			listuser.add(userModel);
		}
		Gson gson = new Gson();
		String json = gson.toJson(listuser);
		PrintWriter pw = resp.getWriter();
		pw.write(json);
		pw.close();

	}

	private void informationUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		String userID = req.getParameter("userID");
		User user = userService.findUser(userID);

		String mobile = user.getMobile();
		String firstName = user.getFirstName();
		String midName = user.getMidName();
		String lastName = user.getLastName();
		String address = user.getAddress();
		String position = user.getPosition();
		String workPlace = user.getWorkPlace();
		UserModel userModel = new UserModel(mobile, firstName, midName, lastName, address, position, workPlace);
		Gson gson = new Gson();
		String json = gson.toJson(userModel);
		PrintWriter pw = resp.getWriter();
		pw.write(json);
		pw.close();

	}
}
