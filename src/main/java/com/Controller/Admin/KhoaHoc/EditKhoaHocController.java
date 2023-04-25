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
import com.Entity.Peoples;
import com.Service.IKhoaHocService;
import com.Service.Impl.KhoaHocServiceImpl;
@WebServlet(urlPatterns = {"/editKhoahoc"})
public class EditKhoaHocController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IKhoaHocService khoahocs = new KhoaHocServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		KhoaHoc kh = khoahocs.getById(Integer.parseInt(id));
		req.setAttribute("kh", kh);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/KhoaHoc/editKhoahoc.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KhoaHoc kh = new KhoaHoc();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				System.out.println("item:" + item.getFieldName());
				if (item.getFieldName().equals("ma_khoahoc")) {
					kh.setMa_khoahoc(Integer.parseInt(item.getString()));
				}
				else if (item.getFieldName().equals("ctdt")) {
					kh.setCtdt(item.getString("UTF-8"));
				}
			khoahocs.edit(kh);
			resp.sendRedirect(req.getContextPath() + "/listKhoahoc");
		}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
