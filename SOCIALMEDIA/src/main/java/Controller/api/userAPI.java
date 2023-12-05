package Controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Entity.User;
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
		resp.setContentType("application/json");// trả về json
		// int userID = Integer.parseInt(req.getParameter("cateStt"));
		String userID = "user1";
		User user = userService.findUser(userID);
		List<User> listfollwing = user.getFollowingUsers();
		Gson gson = new Gson();
		String json = gson.toJson(listfollwing);
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
		System.out.println("vao day 1");
		// List<User> listfollower = user.getFollowers();
		System.out.println("vao day 2");
		// System.out.println(listfollower);
		Gson gson = new Gson();
		// String json = gson.toJson(listfollower);
		String json = gson.toJson(user);
		PrintWriter pw = resp.getWriter();
		pw.write(json);
		pw.close();

	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		User updatedUser = gson.fromJson(req.getReader(), User.class);
		User user = userService.findUser(updatedUser.getUserID());
		user.setMobile(updatedUser.getMobile());
		/*
		user.setCreateDate(updatedUser.getCreateDate());
		user.setFirstName(updatedUser.getFirstName());
		user.setMidName(updatedUser.getMidName());
		user.setLastName(updatedUser.getLastName());
		user.setAddress(updatedUser.getAddress());
		user.setBiography(updatedUser.getBiography());
		user.setPosition(updatedUser.getPosition());
		user.setWorkPlace(updatedUser.getWorkPlace());
		user.setAvatar(updatedUser.getAvatar());*/

		userService.update(user);
		// Viết thông báo kết quả
		PrintWriter out = resp.getWriter();
		out.println("Đã sửa thông tin user thành công");
		out.close();
	}

}
