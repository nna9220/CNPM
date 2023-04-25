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
@WebServlet(urlPatterns = {"/editDKGV"})
public class EditDotDangKyGiangVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDotDangKyGiangVienService dangkys = new DotDangKyGiangVienServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("id"));
		String id = req.getParameter("id");
		DangKyGiangVien dk = dangkys.getById(Integer.parseInt(id));
		req.setAttribute("dk", dk);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/GiangVien/editDotDangKy.jsp");
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
				if(item.getFieldName().equals("id")) {
					dks.setId(Integer.parseInt(item.getString()));
				}
				else if(item.getFieldName().equals("ngaybatdau")) {
					dks.setNgaybatdau(item.getString());
				}
				else if(item.getFieldName().equals("ngayketthuc")) {
					dks.setNgayketthuc(item.getString());
				}
			}
			dangkys.edit(dks);
			resp.sendRedirect(req.getContextPath() + "/taodotDKGV");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
