package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.gson.Gson;

import firebase.FireBaseService;

@WebServlet(urlPatterns = "/dangnhap")
public class Login extends HttpServlet {

	public FireBaseService firebase = new FireBaseService();
	public FirebaseAuth auth = firebase.getAuth();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try { // idToken comes from theclient app (shown above)
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			Gson gson = new Gson();
			String tokenId = gson.fromJson(req.getReader(), String.class); // gọi hàm fromJson để chuyển từ String sang
																			// Object

			// idToken comes from the client app (shown above)
			FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(tokenId);
			String uid = decodedToken.getUid();
			if (uid != null) {
				System.out.println("uid đã đăng nhập: " + uid);
				// tạo session khi user đăng nhập thành công
				HttpSession session = req.getSession();
				session.setAttribute("uid", uid);
				// trả về status thành công
				resp.setStatus(HttpServletResponse.SC_OK);
				resp.getWriter().write("Đăng nhập thành công!");
			}

		} catch (FirebaseAuthException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
//