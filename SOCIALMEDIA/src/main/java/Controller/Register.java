package Controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.google.firebase.auth.UserRecord;

import Entity.User;
import Model.UserModel;
import Services.IUserService;
import Services.UserServiceImpl;
import Utils.Email;
import firebase.FireBaseService;

@WebServlet(urlPatterns = { "/dangki", "/xacthuctaikhoan" })
public class Register extends HttpServlet {
	public FireBaseService firebaseService = new FireBaseService();
	public IUserService userService = new UserServiceImpl();
	/*
	 * public static void main(String[] args) throws FirebaseAuthException { //
	 * System.out.println(fbService.createUserWithEmailAndPass(null));
	 * firebaseService.createUserWithEmailAndPass(null); }
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if (url.contains("dangki")) {
			postRegister(req, resp);
		} else if (url.contains("xacthuctaikhoan")) {
			postVerifyCode(req, resp);
		}
	}

	public void postRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		try {
			UserModel user = new UserModel();
			BeanUtils.populate(user, req.getParameterMap());
			System.out.println("user bean: " + user);
			Email sm = new Email();
			String code = sm.getRandom();
			user.setCode(code);
			boolean test = sm.sendEmail(user);

			if (test) {
				HttpSession session = req.getSession();
				session.setAttribute("account", user);
				System.out.println("SEND EMAIL SUCCESS");

				resp.sendRedirect(req.getContextPath() + "/views/verifyCode.jsp");
			}
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	public void postVerifyCode(HttpServletRequest req, HttpServletResponse resp) {
		resp.setContentType("text/html;charset=UTF-8");
		try {
			HttpSession session = req.getSession();
			UserModel userModel = (UserModel) session.getAttribute("account");
			String code = req.getParameter("code");
			if (code.equals(userModel.getCode())) {
				System.out.println("XAC THUC THANH CONG");
				// tạo tài khoản lên firebase
				try {
					UserRecord userRecord = firebaseService.createUserWithEmailAndPass(userModel);
//					System.out.println("record user after created : " + userRecord.getUid());
					String uid = userRecord.getUid();
					// insert user vào database với uid đã cài đặt
					User user= new User();
					user.setUserID(uid);
					user.setMobile(userModel.getMobile());
					user.setCreateDate(new Date());
					user.setFirstName(userModel.getFirstName());
					user.setMidName(userModel.getMidName());
					user.setLastName(userModel.getLastName());
					user.setAddress(userModel.getAddress());
					user.setPosition(userModel.getPosition());
					user.setWorkPlace(userModel.getWorkPlace());
					userService.insert(user);
					// chuyển quan trang home khi đăng nhập thành công
					resp.sendRedirect(req.getContextPath()+"/home");
					System.out.println("end create account ");
				} catch (Exception e) {
					e.printStackTrace();
				}
				

			} else {
				System.out.println("Xac thuc that bai");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
