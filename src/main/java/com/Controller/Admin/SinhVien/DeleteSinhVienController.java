package com.Controller.Admin.SinhVien;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.ISinhVienService;
import com.Service.Impl.SinhVienServiceImpl;
@WebServlet(urlPatterns = {"/DeleteStudent"})
public class DeleteSinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISinhVienService sinhvien = new SinhVienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		sinhvien.delete(req.getParameter("id"),req.getParameter("email"));
		resp.sendRedirect(req.getContextPath() + "/Studentlist");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
