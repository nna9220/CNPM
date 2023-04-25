package com.Controller.Web.SinhVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.DeTai;
import com.Service.IDeTaiService;
import com.Service.Impl.DeTaiServiceImpl;
@WebServlet(urlPatterns = {"/success"})
public class Successfull extends HttpServlet {

	IDeTaiService dangkys = new DeTaiServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DeTai> detai = dangkys.getAll();
		req.setAttribute("detais", detai);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/web/sinhvien/successfull.jsp");
		dispatcher.forward(req, resp);
	}

	private static final long serialVersionUID = 1L;
	

}
