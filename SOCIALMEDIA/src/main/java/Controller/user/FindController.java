package Controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import Services.IUserService;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = { "/timkiem" })
public class FindController extends HttpServlet {
	IUserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		String url = req.getRequestURL().toString();
		if (url.contains("timkiem")) {
			String userID = "user1";// cài cứng để tuấn làm follow
			String keyword = req.getParameter("keyword");
			String indexP = req.getParameter("index");
			System.out.println(indexP);
			System.out.println(keyword);
			if (indexP == null) {
				indexP = "1";
			}
			int index = Integer.parseInt(indexP);

			Long countP = userService.countSearchUsers(keyword);
			// chia trang cho count
			Long endPage = countP / 10;
			if (countP % 10 != 0) {
				endPage++;
			}
			// TODO Auto-generated method stub
			List<User> listuser = userService.paginationPageSearchUsers(index - 1, 10,keyword);
			// Xử lí bài toán

			// đẩy dữ liệu ra view
			req.setAttribute("listUser", listuser);
			req.setAttribute("countAll", countP);
			req.setAttribute("endP", endPage);
			req.setAttribute("tag", index);
			req.setAttribute("userID", userID);
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/resultFind.jsp");
			rd.forward(req, resp);
		}*/
		
		/*
		String keyword = req.getParameter("keyword");
		List<User> listuser = userService.searchUsersByKeyword(keyword);
		req.setAttribute("listuser", listuser);
		System.out.println(listuser);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/resultFind.jsp");
		rd.forward(req, resp);*/
		
		System.out.println("vào keywword");
		String userID = "user1";// cài cứng để tuấn làm follow
		String keyword = req.getParameter("keyword");
		String indexP = req.getParameter("index");
		System.out.println(indexP);
		System.out.println(keyword);
		if (indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);

		Long countP = userService.countSearchUsers(keyword);
		// chia trang cho count
		Long endPage = countP / 2;
		if (countP % 2 != 0) {
			endPage++;
		}
		// TODO Auto-generated method stub
		List<User> listuser = userService.paginationPageSearchUsers(index - 1, 2,keyword);
		// Xử lí bài toán
		System.out.println(listuser);
		// đẩy dữ liệu ra view
		req.setAttribute("listuser", listuser);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);
		req.setAttribute("userID", userID);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/resultFind.jsp");
		rd.forward(req, resp);
	}
}
