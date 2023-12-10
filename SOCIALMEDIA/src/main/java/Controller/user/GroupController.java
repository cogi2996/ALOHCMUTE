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

import Dao.IUserDAO;
import Entity.Group;
import Entity.User;
import Model.GroupModel;
import Services.GroupServiceImpl;
import Services.IUserService;
import Services.UserServiceImpl;
import Services.iGroupService;
@WebServlet(urlPatterns = {"/grouppost/searchpost","/grouppost/allgrouppost","/timkiem/listusergroup","/timkiem/searchusergroup","/group/allGroup/searchgroup","/group/allGroup/listgroup","/group/allGroup/mygroup", "/group/allGroup/creategroup"})
public class GroupController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	iGroupService groupService = new GroupServiceImpl();
	int danhdau=-1;
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("searchpost")){
			SearchPostGroup(req, resp);
		}
		else if(url.contains("group")) {
			findAll(req, resp);
		}
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
		}else if (url.contains("mygroup")) {
			findMyGroup(req, resp);
		}else if (url.contains("creategroup")) {
			createGroup(req,resp);
			req.getRequestDispatcher("/views/user/listGroup.jsp").forward(req, resp);
		}
	}
	private void createGroup(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	private void findMyGroup(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
			List<User> users = group.getMember();
			int numberOfFollower = 0;
			for (User u : users) {
				numberOfFollower++;
			}

			GroupModel groupmodel = new GroupModel(groupID, groupName, createTime, createrId, numberOfFollower);
			listgroupmodel.add(groupmodel);
		}
		listusergroup = user.getCreatedGroup();
		for (Group group : listusergroup) {

			int groupID = group.getGroupID();
			String groupName = group.getGroupName();
			Date createTime = group.getCreateTime();
			User admin = group.getAdmin();
			String createrId = admin.getUserID();
			List<User> users = group.getMember();
			int numberOfFollower = 0;
			for (User u : users) {
				numberOfFollower++;
			}

			GroupModel groupmodel = new GroupModel(groupID, groupName, createTime, createrId, numberOfFollower);
			listgroupmodel.add(groupmodel);
		}
		req.setAttribute("listGroup", listgroupmodel);
		System.out.println(listgroupmodel);
		System.out.println(userID);
		req.getRequestDispatcher("/views/user/listGroup.jsp").forward(req, resp);
		
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
		Long endPage = countP / 2;
		if (countP % 2 != 0) {
			endPage++;
		}
		List<User> listuser = groupService.paginationPageListUsersGroup(index - 1, 2,groupID);
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
		String userID = "user1";// cài cứng để tuấn làm follow
		int groupID = Integer.parseInt(req.getParameter("groupID"));
		String keyword = req.getParameter("keyword");
		String indexP = req.getParameter("index");

		if (indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);
		Long countP = groupService.CountSearchUsersGroup(groupID,keyword);
		// chia trang cho count
		Long endPage = countP / 2;
		if (countP % 2 != 0) {
			endPage++;
		}
		List<User> listuser = groupService.paginationPageSearchUsersGroup(index - 1, 2,groupID,keyword);
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
		rd.forward(req, resp);
	}
	private void AllGroupPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int groupID = Integer.parseInt(req.getParameter("groupID"));
		Group group = new Group();
		group = groupService.findGroup(groupID);
		Long countUserGroup = groupService.CountListUsersGroup(groupID);
		req.setAttribute("groupID", groupID);
		req.setAttribute("group", group);
		req.setAttribute("countUserGroup", countUserGroup);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/groupPost.jsp");
		rd.forward(req, resp);
		
	}
}
