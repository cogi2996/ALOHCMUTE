package Controller.api;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Entity.Follow;
import Services.FollowServiceImpl;
import Services.IFollowService;

@WebServlet(urlPatterns = "/api/v1/userFollow")
public class UserAPI extends HttpServlet{
	IFollowService followService = new FollowServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		System.out.println("here");
		if(url.contains("userFollow")) {
			String sourceID = req.getParameter("sourceID");
			String targetID = req.getParameter("targetID");
			System.out.println(sourceID);
			Follow newFollow = new Follow(sourceID,targetID,new Date());
			followService.insert(newFollow);
		}
		
	}
	
}
