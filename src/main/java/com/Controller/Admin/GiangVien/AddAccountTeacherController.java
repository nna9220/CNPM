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

import com.Entity.Accounts;
import com.Entity.Peoples;
import com.Service.IAccountService;
import com.Service.IGiangVienService;
import com.Service.ISinhVienService;
import com.Service.Impl.AccountServiceImpl;
import com.Service.Impl.GiangienServiceImpl;
import com.Service.Impl.SinhVienServiceImpl;
@WebServlet(urlPatterns = {"/addAccTeacher"})
public class AddAccountTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IGiangVienService giangvien = new GiangienServiceImpl();
	IAccountService account = new AccountServiceImpl();
	ISinhVienService sinhvien = new SinhVienServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		Peoples pp = giangvien.get(id);
		req.setAttribute("gv", pp);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/GiangVien/addAccTeacher.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Accounts acc =  new Accounts();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				if (item.getFieldName().equals("username")) {
					acc.setUsername(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("password")) {
					acc.setPassword(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("roleid")) {
					acc.setRoleid(Integer.parseInt(item.getString()));
				}
			}
			System.out.println(acc.getUsername());
			Peoples gvid = sinhvien.getByEmail(acc.getUsername());
			account.insert(acc);
			resp.sendRedirect(req.getContextPath() + "/detailTeacher?id=" + gvid.getId());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
