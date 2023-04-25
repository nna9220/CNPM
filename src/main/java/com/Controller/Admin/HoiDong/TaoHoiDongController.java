package com.Controller.Admin.HoiDong;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.DAO.AccountDAO;
import com.Entity.DeTai;
import com.Entity.GiangVien;
import com.Entity.HoiDong;
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;
import com.Service.IDeTaiService;
import com.Service.IGiangVienService;
import com.Service.IHoiDongService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.GiangienServiceImpl;
import com.Service.Impl.HoiDongServiceImpl;

@WebServlet(urlPatterns = { "/taohoidong" })
public class TaoHoiDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IHoiDongService hoidongs = new HoiDongServiceImpl();
	IGiangVienService gvService = new GiangienServiceImpl();
	IDeTaiService detaiService = new DeTaiServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println(id);
		DeTai detai = detaiService.get(id);
		HoiDong hoidong = hoidongs.getByIdDT(id);
		if(hoidong !=null) {
			Peoples gv1 = gvService.get(hoidong.getGiangvien1());
			req.setAttribute("gv1", gv1);
			Peoples gv2 = gvService.get(hoidong.getGiangvien2());
			req.setAttribute("gv2", gv2);
			Peoples gv3 = gvService.get(hoidong.getGiangvien3());
			req.setAttribute("gv3", gv3);
			Peoples gv4 = gvService.get(hoidong.getGiangvien4());
			req.setAttribute("gv4", gv4);
			Peoples gv5 = gvService.get(hoidong.getGiangvien5());
			req.setAttribute("gv5", gv5);
		}
		List<Peoples> gvList = gvService.getAll();
		req.setAttribute("detai", detai);
		req.setAttribute("gvList", gvList);
		req.setAttribute("hd", hoidong);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/HoiDong/taohoidong.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HoiDong hoidong = new HoiDong();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				System.out.println(item);
				if (item.getFieldName().equals("ma_giangvien")) {
					hoidong.setGiangvien1(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("ma_detai")) {
					hoidong.setDetai(Integer.parseInt(item.getString()));
				} 
			}
			System.out.println("Mã" +hoidong.getMa_hd());
			hoidongs.insert1(hoidong);
			System.out.println("Mã" +hoidong.getDetai());
			resp.sendRedirect(req.getContextPath() + "/taohoidong?id=" +hoidong.getDetai());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
