package Controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.google.gson.Gson;

import Entity.Chat;
import Entity.User;
import Services.ChatServiceImpl;
import Services.IChatService;

@WebServlet(urlPatterns = { "/api/v1/chat/*" })
public class ChatAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IChatService _chatService = new ChatServiceImpl();

	public ChatAPI() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if (url.contains("/")) {
			findBySourceId(req, res);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("/insert")) {
			insert(req, res);
		} else if (url.contains("/delete")) {
			delete(req, res);
		}
	}

	private void findBySourceId(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		// Trả về danh sách user đã chat
		String sourceId = req.getParameter("user-id");
		List<User> listEntity = _chatService.findBySourceId(sourceId);
		Gson gson = new Gson();
		String json = gson.toJson(listEntity);
		PrintWriter pw = res.getWriter();
		pw.write(json);
		pw.close();
	}

	private void insert(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		Chat entity = new Chat();
		try {
			// Mapping giá trị form to object
			BeanUtils.populate(entity, req.getParameterMap());
			PrintWriter pw = res.getWriter();
			pw.write(entity.getSourceId()+ entity.getTargetId());
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		_chatService.insert(entity);
	}

	private void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		Chat entity = new Chat();
		try {
			// Mapping giá trị form to object
			BeanUtils.populate(entity, req.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		_chatService.delete(entity);
	}
}
