package com.Controller.Admin.GiangVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Peoples;
import com.Service.IGiangVienService;
import com.Service.Impl.GiangienServiceImpl;
@WebServlet(urlPatterns = {"/searchTeacher"})
public class SearchTeacherController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IGiangVienService giangvien = new GiangienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String key = req.getParameter("txt");
		List<Peoples> peoples = giangvien.search(key);
		req.setAttribute("gvList", peoples);
		RequestDispatcher dispatcher =req.getRequestDispatcher("/views/admin/GiangVien/giangvien-list.jsp");
		dispatcher.forward(req, resp);
	}
}
