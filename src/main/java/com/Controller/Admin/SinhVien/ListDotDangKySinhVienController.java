package com.Controller.Admin.SinhVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.DangKySinhVien;
import com.Service.IDotDangKySinhVienService;
import com.Service.Impl.DotDangKySinhVienServiceImpl;
@WebServlet(urlPatterns = {"/dotdangkysv"})
public class ListDotDangKySinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDotDangKySinhVienService dangky = new DotDangKySinhVienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DangKySinhVien> dk = dangky.getAll();
		req.setAttribute("dk", dk);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/SinhVien/dotdangky-sv.jsp");
		dispatcher.forward(req, resp);
	}

}
