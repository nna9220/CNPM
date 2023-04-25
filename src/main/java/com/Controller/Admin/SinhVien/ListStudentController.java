package com.Controller.Admin.SinhVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.Impl.SinhVienServiceImpl;
import com.Entity.Peoples;
import com.Service.ISinhVienService;

@WebServlet(urlPatterns = {"/Studentlist"})
public class ListStudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ISinhVienService svService = new SinhVienServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Peoples> svList = svService.getAll();
		req.setAttribute("svList", svList);
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/views/admin/SinhVien/SinhVien-list.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
}
