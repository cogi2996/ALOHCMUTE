package Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Services.GroupServiceImpl;
import Services.iGroupService;

@WebServlet(urlPatterns = {"/group"})
public class Group extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	iGroupService groupService = new GroupServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("group")) {
			req.getRequestDispatcher("/views/user/groups.jsp").forward(req, resp);
		}
	}
	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String url = req.getRequestURL().toString();
//		if(url.contains("group")) {
//			int id = Integer.parseInt(req.getParameter("id"));
//			List<Entity.Group> groups = groupService.findGroupUser(id);
//			req.setAttribute("groups", groups);
//			
//			resp.sendRedirect(req.getContextPath() + "/group");
//		}
//	}
}
