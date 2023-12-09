package Controller.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Entity.GroupMember;
import Services.GroupMemberServiceImpl;
import Services.IGroupMemberService;

@WebServlet(urlPatterns = { "/api/v1/groupmember"})
public class GroupMemberAPI extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IGroupMemberService groupMemberService = new GroupMemberServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		try {
			Gson gson = new Gson();
			GroupMember groupMember = gson.fromJson(req.getReader(), GroupMember.class);
			System.out.println(groupMember);
			groupMemberService.insert(groupMember);
			resp.setStatus(HttpServletResponse.SC_OK);
			resp.getWriter().write("Group insert successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		}
	}
}
