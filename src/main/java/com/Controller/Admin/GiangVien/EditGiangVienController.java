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

import com.Entity.Peoples;
import com.Service.IGiangVienService;
import com.Service.Impl.GiangienServiceImpl;

@WebServlet(urlPatterns = {"/editTeacher"})
public class EditGiangVienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IGiangVienService giangvien = new GiangienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		Peoples pp = giangvien.get(id);
		req.setAttribute("gv", pp);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/GiangVien/editGiangVien.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Peoples people  = new Peoples();
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
				if (item.getFieldName().equals("id")) {
					people.setId(item.getString("UTF-8"));
				}
				else if (item.getFieldName().equals("hoten")) {
					people.setHoten(item.getString("UTF-8"));
				}
//				else if (item.getFieldName().equals("ngaysinh")) {
//					people.setNgaysinh(item.getString());
//				}
//				else if (item.getFieldName().equals("gioitinh")) {
//					people.setGioitinh(Integer.parseInt(item.getString()));
//				}
//				else if (item.getFieldName().equals("diachi")) {
//					people.setDiachi(item.getString("UTF-8"));
//				}
//				else if (item.getFieldName().equals("sdt")) {
//					people.setSdt(item.getString("UTF-8"));
//				}
//				else if (item.getFieldName().equals("email")) {
//					people.setEmail(item.getString("UTF-8"));
//				}
			giangvien.edit(people);
			resp.sendRedirect(req.getContextPath() + "/GiangVienlist");
		}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}

}
