package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.gson.Gson;

import Services.UserServiceImpl;
import firebase.FireBaseService;

@WebServlet(urlPatterns = "/dangnhap")
public class Login extends HttpServlet {
	private FirebaseAuth auth;
	private FireBaseService firebaseService;
	@Override
	public void init() throws ServletException {
		if(getServletContext().getAttribute("firebaseService")==null) {
			this.firebaseService  = new FireBaseService();
			getServletContext().setAttribute("firebaseService", this.firebaseService);
			this.auth = this.firebaseService.getAuth();
		}
		else {
			this.firebaseService = (FireBaseService)getServletContext().getAttribute("firebaseService");
			this.auth = firebaseService.getAuth();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			Gson gson = new Gson();

			// Lấy tokenID từ header Authorization
			String authorizationHeader = req.getHeader("Authorization");
			String tokenId = null;
					
			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				tokenId = authorizationHeader.substring(7); // Bỏ qua phần "Bearer "
			}
			
			if (tokenId != null && !tokenId.isEmpty()) {
				// Xác thực tokenID từ Firebase
				FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(tokenId);
				String uid = decodedToken.getUid();

				if (uid != null) {
					System.out.println("uid đã đăng nhập: " + uid);

					// Tạo session khi người dùng đăng nhập thành công
					HttpSession session = req.getSession();
					session.setAttribute("uid", uid);
					session.setAttribute("role", new UserServiceImpl().findUser(uid).getRole());
					// Trả về trạng thái thành công
					resp.setStatus(HttpServletResponse.SC_OK);
					resp.getWriter().write("Đăng nhập thành công!");
				}
			} else {
				// Xử lý khi không có hoặc tokenID không hợp lệ
				resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				resp.getWriter().write("Token không hợp lệ!");
			}
		} catch (FirebaseAuthException e) {
			// Xử lý lỗi xác thực từ Firebase
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			resp.getWriter().write("Lỗi xác thực từ Firebase: " + e.getMessage());
		}
	}

}
//