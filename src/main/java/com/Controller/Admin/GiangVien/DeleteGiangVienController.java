package com.Controller.Admin.GiangVien;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.IGiangVienService;
import com.Service.Impl.GiangienServiceImpl;
@WebServlet(urlPatterns = {"/DeleteTeacher"})
public class DeleteGiangVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IGiangVienService giangvien = new GiangienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		giangvien.delete(req.getParameter("id"));
		resp.sendRedirect(req.getContextPath() + "/GiangVienlist");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
