package Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Entity.Group;
import Entity.User;
import Services.GroupServiceImpl;
import Services.iGroupService;
@WebServlet(urlPatterns = {"/group/searchpost","/group/listuser","/group/searchusergroup","/group/searchgroup","/group"})
public class GroupController extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	iGroupService groupService = new GroupServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("searchpost")){
			SearchPostGroup(req, resp);
		}
		// tin them
		else if(url.contains("listuser")) {
			ListUserInGroup(req, resp);
		}
		else if(url.contains("searchusergroup")) {
			SearchUserInGroup(req, resp);
		}
		else if(url.contains("searchgroup")) {
			SearchGroupbygroupName(req, resp);
		}
		else if(url.contains("group")) {
			req.getRequestDispatcher("/views/user/groups.jsp").forward(req, resp);
		}
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
		/*
		int groupID = Integer.parseInt(req.getParameter("groupID"));
		Group group = groupService.findGroup(groupID);
		List<User> usermember = group.getMember();
		req.setAttribute("usermember", usermember);
		System.out.println(usermember);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/listUserInGroup.jsp");
		rd.forward(req, resp);*/
		String userID = "user1";// cài cứng để tuấn làm follow
		int groupID = Integer.parseInt(req.getParameter("groupID"));
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
		req.setAttribute("listuser", listuser);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);
		req.setAttribute("userID", userID);
		req.setAttribute("groupID", groupID);
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
}
