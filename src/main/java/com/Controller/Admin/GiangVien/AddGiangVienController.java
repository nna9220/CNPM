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

import com.Entity.GiangVien;
import com.Entity.Peoples;
import com.Service.IGiangVienService;
import com.Service.Impl.GiangienServiceImpl;
@WebServlet(urlPatterns = {"/AddTeacher"})
public class AddGiangVienController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	IGiangVienService gv = new GiangienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/views/admin/GiangVien/addGiangvien.jsp");
				dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GiangVien giangvien = new GiangVien();
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
				if (item.getFieldName().equals("ma_giangvien")) {
					peoples.setId(item.getString("UTF-8"));
					giangvien.setMa_giangvien(item.getString("UTF-8"));
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
				else if(item.getFieldName().equals("roleid")) {
					peoples.setRoleid(Integer.parseInt(item.getString()));
				}
				else if(item.getFieldName().equals("roleid")) {

					if(peoples.getRoleid() == 2)
					{
						giangvien.setChucvu("Giảng viên");
					}
					else if(peoples.getRoleid() == 3)
					{
						giangvien.setChucvu("Trưởng bộ môn");
					}
				}
			}
			gv.insert(peoples,giangvien);
			request.setAttribute("message", "Đã thêm thành công");
			response.sendRedirect(request.getContextPath() + "/GiangVienlist");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
