package Controller.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Entity.HiringPost;
import Services.IHiringPostService;
import Services.HiringPostServiceImpl;

@WebServlet(urlPatterns = { "/api/v1/hiring-post/*" })
public class HiringPostAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IHiringPostService _hiringPostService = new HiringPostServiceImpl();

	public HiringPostAPI() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String url = req.getRequestURI().toString();

		if (url.contains("/detail")) {
			findById(req, res);
		} else if (url.contains("/")){
			findAll(req, res);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void findAll(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		List<HiringPost> listEntity = _hiringPostService.findAll();
		Gson gson = new Gson();
		String json = gson.toJson(listEntity);
		PrintWriter pw = res.getWriter();
		pw.write(json);
		pw.close();
	}

	private void findById(HttpServletRequest req, HttpServletResponse res) throws IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("application/json");
		int id = Integer.parseInt(req.getParameter("id"));
		HiringPost entity = _hiringPostService.findById(id);
		Gson gson = new Gson();
		String json = gson.toJson(entity);
		PrintWriter pw = res.getWriter();
		pw.write(json);
		pw.close();
	}
}
