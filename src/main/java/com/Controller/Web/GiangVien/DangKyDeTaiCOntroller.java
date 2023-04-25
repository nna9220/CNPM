package com.Controller.Web.GiangVien;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
import com.Entity.DeTai;
import com.Service.IDeTaiService;
import com.Service.IDotDangKyGiangVienService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.DotDangKyGiangVienServiceImpl;

@WebServlet(urlPatterns = { "/Dangkydetai" })
public class DangKyDeTaiCOntroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDeTaiService detais = new DeTaiServiceImpl();
	IDotDangKyGiangVienService timedangky = new DotDangKyGiangVienServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern("yyyy");
		String format = simpleDateFormat.format(date);
		String id = req.getParameter("id");
		
		//hôm nay
		LocalDate test1 = LocalDate.now();
		System.out.println(test1);
		
		//đợt 1
		DangKyGiangVien a = timedangky.getById(1);
		LocalDate start = LocalDate.parse(a.getNgaybatdau());
		LocalDate end = LocalDate.parse(a.getNgayketthuc());
		//đợt 2
		DangKyGiangVien b = timedangky.getById(3);
		LocalDate start2 = LocalDate.parse(b.getNgaybatdau());
		LocalDate end2 = LocalDate.parse(b.getNgayketthuc());
		System.out.println(test1.compareTo(end));
		List<DeTai> detai = detais.detaiByGV(id);
		req.setAttribute("nam", format);
		req.setAttribute("detai", detai);
		if ((test1.compareTo(start) >= 0 && test1.compareTo(end) <= 0) || 
				(test1.compareTo(start2) >= 0 && test1.compareTo(end2)<=0) ) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/giangvien/dangkydetai.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/giangvien/noregister.jsp");
			dispatcher.forward(req, resp);
		}
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
				if (item.getFieldName().equals("ten_detai")) {
					detai.setTen_detai(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("ma_chuyennganh")) {
					detai.setMa_chuyennganh(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("gvhd")) {
					detai.setGvhd(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("trangthai")) {
					detai.setTrangthai(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("soluongsinhviendangky")) {
					detai.setSoluongsinhviendangky(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("nam_totnghiep")) {
					detai.setNam_totnghiep(Integer.parseInt(item.getString()));
				}
			}
			detais.insert(detai);
			req.setAttribute("message", "Đã thêm thành công");
			resp.sendRedirect(req.getContextPath() + "/Dangkydetai?id=" + detai.getGvhd());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}