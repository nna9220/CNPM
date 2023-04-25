package com.Controller.Admin.KhoaHoc;

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

import com.Entity.KhoaHoc;
import com.Service.IKhoaHocService;
import com.Service.Impl.KhoaHocServiceImpl;
@WebServlet(urlPatterns = {"/addKhoaHoc"})
public class AddKhoaHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IKhoaHocService khoahocs = new KhoaHocServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/views/admin/KhoaHoc/addKhoahoc.jsp");
				dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KhoaHoc khoahoc = new KhoaHoc();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("ten_khoahoc")) {
					khoahoc.setTen_khoahoc(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("nienkhoa")) {
					khoahoc.setNienkhoa(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("nam_nhaphoc")) {
					khoahoc.setNam_nhaphoc(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("nam_ketthuc")) {
					khoahoc.setNam_ketthuc(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("lopsinhvien")) {
					khoahoc.setLopsinhvien(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("ctdt")) {
					khoahoc.setCtdt(item.getString("UTF-8"));
				}
			}
			khoahocs.insert(khoahoc);
			request.setAttribute("message", "Đã thêm thành công");
			response.sendRedirect(request.getContextPath() + "/listKhoahoc");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
