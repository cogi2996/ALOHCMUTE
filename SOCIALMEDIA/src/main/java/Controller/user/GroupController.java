package Controller.user;

import java.io.IOException;
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

import Dao.IUserDAO;
import Entity.Group;
import Entity.User;
import Entity.UserPost;
import Model.GroupModel;
import Services.GroupServiceImpl;
import Services.IUserPostService;
import Services.IUserService;
import Services.UserPostServiceImpl;
import Services.UserServiceImpl;
import Services.iGroupService;

@WebServlet(urlPatterns = {"/grouppost/searchpost","/grouppost/allgrouppost","/timkiem/listusergroup","/timkiem/searchusergroup","/group/allGroup/searchgroup","/group/allGroup/listgroup","/group/allGroup/mygroup", "/group/allGroup/creategroup"})
public class GroupController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	iGroupService groupService = new GroupServiceImpl();
	int danhdau=-1;
	IUserService userService = new UserServiceImpl();
	IUserPostService userPostService = new UserPostServiceImpl();// tín thêm
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("searchpost")){
			SearchPostGroup(req, resp);
		}
		// tin them
		else if(url.contains("listusergroup")) {
			ListUserInGroup(req, resp);
		}
		else if(url.contains("searchusergroup")) {
			SearchUserInGroup(req, resp);
		}
		else if(url.contains("searchgroup")) {
			SearchGroupbygroupName(req, resp);
		}
		else if(url.contains("allgrouppost")) {
			AllGroupPost(req, resp);
		}
//		DAT BEGIN HERE
		else if(url.contains("listgroup")) {
			findAll(req, resp);
		}
		else if(url.contains("mygroup")) {
			MyGroupUser(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("creategroup")){
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			HttpSession session = req.getSession(false);
			String userID = (String) session.getAttribute("uid");
	        String groupName = req.getParameter("groupName");
	        Date createTime =  new Date();
	        Group group = new Group();
	        group.setGroupName(groupName);
	        group.setCreateTime(createTime);

	        group.setAdmin(userService.findUser(userID));
	        groupService.insertGroup(group);
			// chuyển view (trang)
			resp.sendRedirect(req.getContextPath() + "/group/allGroup/listgroup");

		}
	}
	private void MyGroupUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//String userID = req.getParameter("userID");
		//String userID = "user5";
		HttpSession session = req.getSession(false);
		String userID = (String) session.getAttribute("uid");
		User usergroup = userService.findUser(userID);
		System.out.println(userID);
		List<Group> listusergroup = usergroup.getUserGroups();
		List<GroupModel> listgroupmodel = new ArrayList<GroupModel>();

		for (Group group : listusergroup) {

			int groupID = group.getGroupID();
			String groupName = group.getGroupName();
			Date createTime = group.getCreateTime();
			User user = group.getAdmin();
			String createrId = user.getUserID();
			
			List<User> users = group.getMember();
			int numberOfFollower = 0;
			for (User u : users) {
				numberOfFollower++;
				}
			
			GroupModel groupmodel = new GroupModel(groupID, groupName, createTime, createrId, numberOfFollower);
			listgroupmodel.add(groupmodel);
		}
		System.out.println(listusergroup);
		req.setAttribute("listGroup", listgroupmodel);
		req.setAttribute("userID", userID);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/listGroup.jsp");
		rd.forward(req, resp);
		
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Group> listGroup = groupService.findAllGroup();
		List<GroupModel> listgroupmodel = new ArrayList<GroupModel>();

		for (Group group : listGroup) {

			int groupID = group.getGroupID();
			String groupName = group.getGroupName();
			Date createTime = group.getCreateTime();
			User user = group.getAdmin();
			String createrId = user.getUserID();
			
			List<User> users = group.getMember();
			int numberOfFollower = 0;
			for (User u : users) {
				numberOfFollower++;
				}
			
			GroupModel groupmodel = new GroupModel(groupID, groupName, createTime, createrId, numberOfFollower);
			listgroupmodel.add(groupmodel);
		}
		// đẩy dl ra view
		req.setAttribute("listGroup", listgroupmodel);
		System.out.println(listGroup);
		req.getRequestDispatcher("/views/user/listGroup.jsp").forward(req, resp);
	}

	private void SearchPostGroup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		int groupID = Integer.parseInt(req.getParameter("groupID"));
		Group group = groupService.findGroup(groupID);
		List<User> usermember = group.getMember();
		req.setAttribute("usermember", usermember);
		System.out.println(usermember);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/groupPostFind.jsp");
		rd.forward(req, resp);
	}
	private void ListUserInGroup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userID = "user1";// cài cứng để tuấn làm follow
		int groupID = Integer.parseInt(req.getParameter("groupID"));
		//int groupID =  11;	
		String indexP = req.getParameter("index");

		if (indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);
		Long countP = groupService.CountListUsersGroup(groupID);
		// chia trang cho count
		Long endPage = countP / 10;
		if (countP % 10 != 0) {
			endPage++;
		}
		List<User> listuser = groupService.paginationPageListUsersGroup(index - 1, 10,groupID);
		// Xử lí bài toán
		// đẩy dữ liệu ra view
		danhdau=0;
		req.setAttribute("danhdau", danhdau);
		req.setAttribute("listuser", listuser);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);
		req.setAttribute("userID", userID);
		req.setAttribute("groupID", groupID);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/usersgroup.jsp");
		rd.forward(req, resp);
		
	}
	private void SearchUserInGroup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = "user4";// cài cứng để tuấn làm follow
		int groupID = Integer.parseInt(req.getParameter("groupID"));
		String keyword = req.getParameter("keyword");
		String indexP = req.getParameter("index");

		if (indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);
		Long countP = groupService.CountSearchUsersGroup(groupID,keyword);
		// chia trang cho count
		Long endPage = countP / 10;
		if (countP % 10 != 0) {
			endPage++;
		}
		List<User> listuser = groupService.paginationPageSearchUsersGroup(index - 1, 10,groupID,keyword);
		// Xử lí bài toán
		// đẩy dữ liệu ra view
		danhdau=1;
		req.setAttribute("danhdau", danhdau);
		req.setAttribute("listuser", listuser);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);
		req.setAttribute("userID", userID);
		req.setAttribute("groupID", groupID);
		req.setAttribute("keyword", keyword);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/usersgroup.jsp");
		rd.forward(req, resp);
		
	}
	private void SearchGroupbygroupName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		String groupName = req.getParameter("groupName");
		String indexP = req.getParameter("index");

		if (indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);
		Long countP = groupService.countSearchGroups(groupName);
		// chia trang cho count
		Long endPage = countP / 10;
		if (countP % 10 != 0) {
			endPage++;
		}
		List<Group> listgroup = groupService.paginationPageSearchGroups(index - 1, 10,groupName);
		System.out.println(listgroup);
		// Xử lí bài toán
		// đẩy dữ liệu ra view
		req.setAttribute("listgroup", listgroup);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/usersgroup.jsp");
		rd.forward(req, resp);*/
		String groupNamesearch = req.getParameter("groupName");
		List<Group> listGroup = groupService.searchGroupbygroupName(groupNamesearch);
		List<GroupModel> listgroupmodel = new ArrayList<GroupModel>();

		for (Group group : listGroup) {
			int groupID = group.getGroupID();
			String groupName = group.getGroupName();
			Date createTime = group.getCreateTime();
			User user = group.getAdmin();
			String createrId = user.getUserID();
			int numberOfFollower = group.getMember().size();
			GroupModel groupmodel = new GroupModel(groupID, groupName, createTime, createrId, numberOfFollower);
			listgroupmodel.add(groupmodel);
		}
		// đẩy dl ra view
		req.setAttribute("listGroup", listgroupmodel);
		req.getRequestDispatcher("/views/user/listGroup.jsp").forward(req, resp);
	}
	private void AllGroupPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int groupID = Integer.parseInt(req.getParameter("groupID"));
		Group group = new Group();
		group = groupService.findGroup(groupID);
		Long countUserGroup = groupService.CountListUsersGroup(groupID);
		List<UserPost> listGroupPost = userPostService.GroupPostBygroupID(groupID);
		req.setAttribute("groupID", groupID);
		req.setAttribute("group", group);
		req.setAttribute("countUserGroup", countUserGroup);
		req.setAttribute("listGroupPost", listGroupPost);
		System.out.println(listGroupPost);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/groupPost.jsp");
		rd.forward(req, resp);
		
	}
}
