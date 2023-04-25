package com.Controller.Admin.GiangVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Entity.DangKyGiangVien;
import com.Service.IDotDangKyGiangVienService;
import com.Service.Impl.DotDangKyGiangVienServiceImpl;
@WebServlet(urlPatterns = {"/taodotDKGV"})
public class TaoDotDangKyGiangVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDotDangKyGiangVienService dangky = new DotDangKyGiangVienServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DangKyGiangVien> dk = dangky.getAll();
		req.setAttribute("dk", dk);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/GiangVien/dotdangky-gv.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DangKyGiangVien dks = new DangKyGiangVien();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if(item.getFieldName().equals("ngaybatdau")) {
					dks.setNgaybatdau(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("ngayketthuc")) {
					dks.setNgayketthuc(item.getString("UTF-8"));
				}
			}
			dangky.insert(dks);
			resp.sendRedirect(req.getContextPath() + "/GiangVienlist");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
