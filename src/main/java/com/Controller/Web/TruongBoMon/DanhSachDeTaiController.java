package com.Controller.Web.TruongBoMon;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.DeTai;
import com.Entity.Peoples;
import com.Service.IDeTaiService;
import com.Service.IGiangVienService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.GiangienServiceImpl;
@WebServlet(urlPatterns = {"/listDeTai"})
public class DanhSachDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDeTaiService detais = new DeTaiServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DeTai> detai = detais.getAll();
		req.setAttribute("detais", detai);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/web/truongbomon/danhsachdetai.jsp");
		dispatcher.forward(req, resp);
	}
}
