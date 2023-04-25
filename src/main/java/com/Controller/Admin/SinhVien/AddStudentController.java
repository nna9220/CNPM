package com.Controller.Admin.SinhVien;

import java.io.File;
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
import com.Entity.SinhVien;
import com.Service.IKhoaHocService;
import com.Service.ISinhVienService;
import com.Service.Impl.KhoaHocServiceImpl;
import com.Service.Impl.SinhVienServiceImpl;



@WebServlet(urlPatterns = {"/AddStudent"})
public class AddStudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	ISinhVienService sv = new SinhVienServiceImpl();
	IKhoaHocService kh = new KhoaHocServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<KhoaHoc> khs = kh.getAll();
		req.setAttribute("khs", khs);
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/views/admin/SinhVien/addSV.jsp");
				dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SinhVien sinhvien = new SinhVien();
		Peoples peoples = new Peoples();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("ma_sinhvien")) {
					peoples.setId(item.getString("UTF-8"));
					sinhvien.setMa_sinhvien(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("hoten")) {
					peoples.setHoten(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("ngaysinh")) {
					peoples.setNgaysinh(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("gioitinh")) {
					peoples.setGioitinh(Integer.parseInt(item.getString()));
				}
				else if(item.getFieldName().equals("diachi")) {
					peoples.setDiachi(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("sdt")) {
					peoples.setSdt(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("email")) {
					peoples.setEmail(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("ma_chuyennganh")) {
					peoples.setMa_chuyennganh(Integer.parseInt(item.getString()));
				}
				else if(item.getFieldName().equals("khoa")) {
					sinhvien.setKhoa(Integer.parseInt(item.getString()));
				}
			}
			sv.insert(peoples,sinhvien);
			response.sendRedirect(request.getContextPath() + "/Studentlist");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
