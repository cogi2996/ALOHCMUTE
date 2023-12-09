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
import Entity.UserPost;
import Services.IUserPostService;
import Services.UserPostServiceImpl;

@WebServlet(urlPatterns = {"/admin-manage/post/listuserpost", "/admin-manage/post/delete", "/admin-manage/post/listUserLike","/admin-manage/post/searchUserPost" })
public class UserPostController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IUserPostService postService = new UserPostServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("delete")) {
			delete(req, resp);
		}
		else if(url.contains("searchUserPost"))
		{
			String keyword = req.getParameter("keyword");
			String indexP = req.getParameter("index");

			if (indexP == null) {
				indexP = "1";
			}
			int index = Integer.parseInt(indexP);

			Long countP = postService.countSearchUserPost(keyword);
			// chia trang cho count
			Long endPage = countP / 10;
			if (countP % 10 != 0) {
				endPage++;
			}
			List<UserPost> listPost = postService.paginationPageSearchUserPost(index - 1, 10,keyword);
			// Xử lí bài toán
			// đẩy dữ liệu ra view
			req.setAttribute("listPost", listPost);
			req.setAttribute("countAll", countP);
			req.setAttribute("endP", endPage);
			req.setAttribute("tag", index);
			req.setAttribute("keyword", keyword);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/findUserPost.jsp");
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
	
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException, ServletException{
		String indexP = req.getParameter("index");
		if (indexP == null) {
			indexP = "1";
		}
		int index = Integer.parseInt(indexP);

		Long countP = postService.countAll();
		// chia trang cho count
		Long endPage = countP / 10;
		if (countP % 10 != 0) {
			endPage++;
		}
		// TODO Auto-generated method stub
		List<UserPost> listPost = postService.paginationPage(index - 1, 10);
		// Xử lí bài toán

		// đẩy dữ liệu ra view
		req.setAttribute("listPost", listPost);
		req.setAttribute("countAll", countP);
		req.setAttribute("endP", endPage);
		req.setAttribute("tag", index);

		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/listuserpost.jsp");
		rd.forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			postService.delete(id);
			req.setAttribute("message", "Xóa thành công");
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "Thất bại");
		}

		RequestDispatcher rd = req.getRequestDispatcher("listuserpost");
		rd.forward(req, resp);
	}
}
