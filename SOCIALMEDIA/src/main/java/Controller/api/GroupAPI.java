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

import Entity.Group;
import Services.GroupServiceImpl;
import Services.iGroupService;

@WebServlet(urlPatterns = {"/api-user-group"})
public class GroupAPI extends HttpServlet{


	private static final long serialVersionUID = 1L;
	
	iGroupService groupService = new GroupServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Group> groups = groupService.findAllGroup();
		Gson gson = new Gson();
		String gString = gson.toJson(groups);
		PrintWriter out = resp.getWriter();
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print(gString);
		out.flush();
		out.close();
	}
	
}
