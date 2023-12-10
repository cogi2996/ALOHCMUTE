package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.firebase.auth.FirebaseAuth;

import Dao.UserDAOImpl;
import Model.UserModel;
import Utils.Email;
import firebase.FireBaseService;
@WebServlet(urlPatterns = "/forgotPassword")
public class forgotPass extends HttpServlet{
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
		req.getRequestDispatcher("/views/forgotPass.jsp").forward(req, resp);
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// nếu tồn tại email thì gửi
		
	}
//	public void sendForgetPass(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//		req.setCharacterEncoding("UTF-8");
//		resp.setCharacterEncoding("UTF-8");
//		try {
//			String email = req.getParameter("email");
////			new UserDAOImpl().findUserByEmail(email).getP
//			UserModel user = new UserModel();
//			BeanUtils.populate(user, req.getParameterMap());
//			System.out.println("user bean: " + user);
//			Email sm = new Email();
//			String code = sm.getRandom();
//			user.setCode(code);
//			boolean test = sm.sendEmail(user);
//
//			if (test) {
//				HttpSession session = req.getSession();
//				session.setAttribute("account", user);
//				System.out.println("SEND EMAIL SUCCESS");
//				resp.sendRedirect(req.getContextPath() + "/views/verifyCode.jsp");
//			}
//		} catch (IllegalAccessException | InvocationTargetException e) {
//			e.printStackTrace();
//		}
//	}
}
