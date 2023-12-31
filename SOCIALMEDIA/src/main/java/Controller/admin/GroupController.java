package Controller.admin;

import java.io.IOException;
import java.sql.SQLException;
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
import Services.IUserService;
import Services.UserServiceImpl;
import Services.iGroupService;


@WebServlet(urlPatterns = {"/admin-manage/group/listgroup", "/admin-manage/group/delete", "/admin-manage/group/members","/admin-manage/group/searchGroup" })
public class GroupController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	iGroupService groupService = new GroupServiceImpl();
	IUserService userService = new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("delete")) {
			delete(req, resp);
		}
		else if(url.contains("members"))
		{
			int id = Integer.parseInt(req.getParameter("id"));
			List<User> members = groupService.findGroup(id).getMember();
			
			req.setAttribute("listUser", members);
			
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listuser.jsp");
			rd.forward(req, resp);
		}
		else if(url.contains("searchGroup"))
		{
			String keyword = req.getParameter("keyword");
			String indexP = req.getParameter("index");

			if (indexP == null) {
				indexP = "1";
			}
			int index = Integer.parseInt(indexP);

			Long countP = groupService.countSearchGroups(keyword);
			// chia trang cho count
			Long endPage = countP / 10;
			if (countP % 10 != 0) {
				endPage++;
			}
			List<Group> listGroup = groupService.paginationPageSearchGroups(index - 1, 10,keyword);
			// Xử lí bài toán
			// đẩy dữ liệu ra view
			req.setAttribute("listGroup", listGroup);
			req.setAttribute("countAll", countP);
			req.setAttribute("endP", endPage);
			req.setAttribute("tag", index);
			req.setAttribute("keyword", keyword);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/findGroup.jsp");
			rd.forward(req, resp);
		}
		try {
			findAll(req, resp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws SQLException , IOException, ServletException{
		String indexP = req.getParameter("index");
		if (indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);

		Long countP = groupService.countAll();
		// chia trang cho count
		Long endPage = countP / 10;
		if (countP % 10 != 0) {
			endPage++;
		}
		// TODO Auto-generated method stub
		List<Group> listGroup = groupService.paginationPage(index - 1, 10);
		// Xử lí bài toán
		
		// đẩy dữ liệu ra view
		req.setAttribute("listGroup", listGroup);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);

		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listgroup.jsp");
		rd.forward(req, resp);
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			groupService.deleteGroup(id);

			req.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Thất bại");
		}

		RequestDispatcher rd = req.getRequestDispatcher("listgroup");
		rd.forward(req, resp);
	}
}
