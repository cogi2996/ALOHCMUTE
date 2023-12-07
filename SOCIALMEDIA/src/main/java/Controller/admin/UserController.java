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

import Entity.User;
import Services.IUserService;
import Services.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin-manage/user/listuser", "/admin-manage/user/delete", "/admin-manage/user/update"})
public class UserController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	IUserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("delete")) {
			delete(req, resp);
		}
		else if(url.contains("update")){
			String id = req.getParameter("id");
			User user = userService.findUser(id);
			req.setAttribute("user", user);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/update-user.jsp");
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

	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException, ServletException{
		String indexP = req.getParameter("index");
		if (indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);

		Long countP = userService.countAll();
		// chia trang cho count
		Long endPage = countP / 10;
		if (countP % 10 != 0) {
			endPage++;
		}
		// TODO Auto-generated method stub
		List<User> listUser = userService.paginationPage(index - 1, 10);
		// Xử lí bài toán

		// đẩy dữ liệu ra view
		req.setAttribute("listUser", listUser);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);

		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listuser.jsp");
		rd.forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String id = req.getParameter("id");
		try {
			userService.delete(id);

			req.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Thất bại");
		}

		RequestDispatcher rd = req.getRequestDispatcher("listuser");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("update")) {
			update(req, resp);
		} 
	}

	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		req.setCharacterEncoding("UTF-8");
		;
		resp.setCharacterEncoding("UTF-8");
		// nhan du lieu tu form
		String mobile = req.getParameter("mobile");
		String firstName = req.getParameter("firstName");
		String midName = req.getParameter("midName");
		String lastName = req.getParameter("lastName");
		String address = req.getParameter("address");
		String position = req.getParameter("position");
		String workPlace = req.getParameter("workPlace");
		String avatar = req.getParameter("avatar");
		String id = req.getParameter("userID");

		// khoi tao model va them du lieu cho model
		User user = new User();
		user.setMobile(mobile);
		user.setFirstName(firstName);
		user.setMidName(midName);
		user.setLastName(lastName);
		user.setAddress(address);
		user.setPosition(position);
		user.setWorkPlace(workPlace);
		user.setAvatar(avatar);
		user.setUserID(id);
		// goi phuong thuc insert
		userService.update(user);

		// chuyen trang
		resp.sendRedirect("listuser");
	}
}
