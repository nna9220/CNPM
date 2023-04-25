package com.Controller.Admin.SinhVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Peoples;
import com.Service.ISinhVienService;
import com.Service.Impl.SinhVienServiceImpl;
@WebServlet(urlPatterns = {"/search"})
public class SearchStudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ISinhVienService sinhvien = new SinhVienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("txt");
		List<Peoples> peoples = sinhvien.search(key);
		req.setAttribute("svList", peoples);
		RequestDispatcher dispatcher =req.getRequestDispatcher("/views/admin/SinhVien/SinhVien-list.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
