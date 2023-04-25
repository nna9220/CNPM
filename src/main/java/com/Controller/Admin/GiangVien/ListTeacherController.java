package com.Controller.Admin.GiangVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.IGiangVienDAO;
import com.Entity.Peoples;
import com.Service.IGiangVienService;
import com.Service.ISinhVienService;
import com.Service.Impl.GiangienServiceImpl;
import com.Service.Impl.SinhVienServiceImpl;

@WebServlet(urlPatterns = {"/GiangVienlist"})
public class ListTeacherController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IGiangVienService svService = new GiangienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Peoples> gvList = svService.getAll();
		req.setAttribute("gvList", gvList);
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/views/admin/GiangVien/giangvien-list.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
