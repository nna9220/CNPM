package com.Controller.Admin.DeTai;

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

import com.Entity.DeTai;
import com.Service.IDeTaiService;
import com.Service.Impl.DeTaiServiceImpl;
@WebServlet(urlPatterns = {"/listDetai"})
public class ListDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDeTaiService detais = new DeTaiServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<DeTai> detai = detais.getAll();
		req.setAttribute("detai", detai);
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/views/admin/DeTai/DeTai-list.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DeTai detai = new DeTai();
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
				if (item.getFieldName().equals("ma_detai")) {
					detai.setMa_detai(Integer.parseInt(item.getString()));
				}
			detais.accessDeTai(detai);
			System.out.println(detai.getMa_detai());
			resp.sendRedirect(req.getContextPath() + "/listDetai");
		}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
	
	
}
