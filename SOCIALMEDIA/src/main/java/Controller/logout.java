package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dangxuat")
public class logout extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false); // false để không tạo phiên mới nếu không tồn tại
		if (session != null) {
			session.invalidate(); // Hủy bỏ phiên làm việc
			resp.sendRedirect(req.getContextPath()+"/dangnhap");
		}
		

	}
}
