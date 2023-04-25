package com.Controller.Admin.SinhVien;

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

import com.Entity.DangKySinhVien;
import com.Service.IDotDangKySinhVienService;
import com.Service.Impl.DotDangKySinhVienServiceImpl;
@WebServlet(urlPatterns = {"/editDKSV"})
public class EditDotDangKySinhVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDotDangKySinhVienService dangkys = new DotDangKySinhVienServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(req.getParameter("id"));
		String id = req.getParameter("id");
		DangKySinhVien dk = dangkys.getById(Integer.parseInt(id));
		req.setAttribute("dk", dk);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/SinhVien/editDotDangKySV.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DangKySinhVien dks = new DangKySinhVien();
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
			resp.sendRedirect(req.getContextPath() + "/dotdangkysv");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
