package com.Controller.Admin.KhoaHoc;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.KhoaHoc;
import com.Service.IKhoaHocService;
import com.Service.Impl.KhoaHocServiceImpl;
@WebServlet(urlPatterns = {"/listKhoahoc"})
public class ListKhoaHocController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IKhoaHocService khoahocs = new KhoaHocServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<KhoaHoc> khs = khoahocs.getAll();
		req.setAttribute("khs", khs);
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/views/admin/KhoaHoc/khoahoc-list.jsp");
				dispatcher.forward(req, resp);
	}
}
