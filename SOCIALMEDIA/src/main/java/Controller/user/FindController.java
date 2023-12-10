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
import Services.GroupServiceImpl;
import Services.IUserService;
import Services.UserServiceImpl;
import Services.iGroupService;

@WebServlet(urlPatterns = { "/timkiem" })
public class FindController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IUserService userService = new UserServiceImpl();
	iGroupService groupService = new GroupServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		String userID = "user1";// cài cứng để tuấn làm follow
		String keyword = req.getParameter("keyword");
		
		String indexP = req.getParameter("index");

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
		List<User> listuser = userService.paginationPageSearchUsers(index - 1, 10,keyword);
		// Xử lí bài toán
		// đẩy dữ liệu ra view
		req.setAttribute("listuser", listuser);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);
		req.setAttribute("userID", userID);
		req.setAttribute("keyword", keyword);
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/resultFind.jsp");
		rd.forward(req, resp);
	}
}
