package Controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Convert;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import Dao.GroupDAOImpl;
import Entity.Group;
import Entity.User;
import Model.GroupModel;
import Services.GroupServiceImpl;
import Services.IUserService;
import Services.UserServiceImpl;
import Services.iGroupService;

@WebServlet(urlPatterns = { "/api-user-group", "/api-user-listgroupuser", "/api-user-addusergroup" })
public class GroupAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	iGroupService groupService = new GroupServiceImpl();
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		String url = req.getRequestURI();

		if (url.contains("api-user-group")) {
			getlistgroup(req, resp);
		} else if (url.contains("api-user-listgroupuser")) {
			getlistgroupuser(req, resp);
		}
		 else if (url.contains("api-user-addusergroup")) {
			 addusergroup(req, resp);
			}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		try {
			Gson gson = new Gson();
			GroupModel groupModel = gson.fromJson(req.getReader(), GroupModel.class);
			System.out.println(groupModel.toString());
			Group newgroup = new Group();

			newgroup.setGroupName(groupModel.getGroupName());
			newgroup.setCreateTime(new Date());
			User admin = userService.findUser(groupModel.getCreaterId()); // Find admin user
			newgroup.setAdmin(admin);
			groupService.insertGroup(newgroup);
			System.out.println(newgroup);
//	        resp.getWriter().write(gson.toJson(group));
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().write("Group insert successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		try {
			// Read data from the request body
			Gson gson = new Gson();
			GroupModel groupModel = gson.fromJson(req.getReader(), GroupModel.class);
			System.out.println(groupModel.toString());
			Group updateGroup = new Group();
			updateGroup = groupService.findGroup(groupModel.getGroupID());

			updateGroup.setGroupID(groupModel.getGroupID());
			updateGroup.setGroupName(groupModel.getGroupName());
			updateGroup.setCreateTime(groupModel.getCreateTime());
			User user = userService.findUser(groupModel.getCreaterId());
			updateGroup.setAdmin(user);

			groupService.updateGroup(updateGroup);
			System.out.println(updateGroup.toString());
			// Send a response
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().write("Group updated successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		}

	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		try {

			String userID = req.getParameter("userID");
			User user = userService.findUser(userID);
			// Read data from the request body
			System.out.println(user.toString());
			Gson gson = new Gson();
			GroupModel groupModel = gson.fromJson(req.getReader(), GroupModel.class);
			System.out.println(groupModel.toString());
			
			String userid = user.getUserID().trim();
			String groupcreaterid = groupModel.getCreaterId().trim();
//			if (userid == groupcreaterid) {
//				groupService.deleteGroup(groupModel.getGroupID());
//				resp.setStatus(HttpServletResponse.SC_OK);
//				resp.getWriter().write("Group delete successfully!");
//			} else {
//				resp.getWriter().write("Group delete fail!");
//			}
			groupService.deleteGroup(groupModel.getGroupID());
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().write("Group delete successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		}
	}

//	API hiển thị toàn bộ danh sách group mà user đang theo dõi
	private void getlistgroupuser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		String userID = req.getParameter("userID");
		User user = userService.findUser(userID);

		List<Group> listusergroup = user.getUserGroups();
		List<GroupModel> listgroupmodel = new ArrayList<GroupModel>();

		for (Group group : listusergroup) {

			int groupID = group.getGroupID();
			String groupName = group.getGroupName();
			Date createTime = group.getCreateTime();
			User admin = group.getAdmin();
			String createrId = admin.getUserID();
//			String userId = user.getUserID();

			GroupModel groupmodel = new GroupModel(groupID, groupName, createTime, createrId);
			listgroupmodel.add(groupmodel);
		}

		Gson gson = new Gson();
		String gString = gson.toJson(listgroupmodel);
		PrintWriter out = resp.getWriter();
		out.print(gString);
		out.flush();
		out.close();
	}

//	API hiển thị toàn bộ danh sách group
	private void getlistgroup(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		List<Group> groups = groupService.findAllGroup();
		List<GroupModel> listgroupmodel = new ArrayList<GroupModel>();

		for (Group group : groups) {

			int groupID = group.getGroupID();
			String groupName = group.getGroupName();
			Date createTime = group.getCreateTime();
			User user = group.getAdmin();
			String createrId = user.getUserID();

			GroupModel groupmodel = new GroupModel(groupID, groupName, createTime, createrId);
			listgroupmodel.add(groupmodel);
		}

		Gson gson = new Gson();
		String gString = gson.toJson(listgroupmodel);
		PrintWriter out = resp.getWriter();
		out.print(gString);
		out.flush();
		out.close();
	}
	//begin tin
	private void addusergroup(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	// end tin
}
