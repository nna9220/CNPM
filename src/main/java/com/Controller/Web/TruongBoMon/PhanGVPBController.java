package com.Controller.Web.TruongBoMon;

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
import com.Entity.Peoples;
import com.Service.IDeTaiService;
import com.Service.IGiangVienService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.GiangienServiceImpl;
@WebServlet(urlPatterns = {"/phangvpb"})
public class PhanGVPBController extends HttpServlet {
	IDeTaiService detais = new DeTaiServiceImpl();
	IGiangVienService gv = new GiangienServiceImpl();
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		DeTai dt = detais.get(id);
		List<Peoples> gvList = gv.getAll();
		req.setAttribute("gvList", gvList);
		req.setAttribute("dt", dt);
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/views/web/truongbomon/phangvpb.jsp");
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
				else if (item.getFieldName().equals("gvpb")) {
					detai.setGvpb(item.getString("UTF-8"));
				}
			detais.distributionTeacher(detai);
			System.out.println(detai.getGvpb());
			resp.sendRedirect(req.getContextPath() + "/listDeTai");
		}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

}
