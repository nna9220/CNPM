package com.Controller.Web.SinhVien;

import java.io.IOException;
import java.time.LocalDate;
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
import com.Entity.Accounts;
import com.Entity.DangKyGiangVien;
import com.Entity.DangKySinhVien;
import com.Entity.DeTai;
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;
import com.Service.IDeTaiService;
import com.Service.IDotDangKySinhVienService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.DotDangKySinhVienServiceImpl;

@WebServlet(urlPatterns = { "/svDKDT" })
public class SinhVienDangKyDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDeTaiService dangkys = new DeTaiServiceImpl();
	IDotDangKySinhVienService timedangky = new DotDangKySinhVienServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// hôm nay
		LocalDate test1 = LocalDate.now();
		System.out.println(test1);

		// đợt 1
		DangKySinhVien a = timedangky.getById(1);
		LocalDate start = LocalDate.parse(a.getNgaybatdau());
		LocalDate end = LocalDate.parse(a.getNgayketthuc());
		// đợt 2
		DangKySinhVien b = timedangky.getById(2);
		LocalDate start2 = LocalDate.parse(b.getNgaybatdau());
		LocalDate end2 = LocalDate.parse(b.getNgayketthuc());
		System.out.println(test1.compareTo(end));
		List<DeTai> detai = dangkys.getAllAccess();
		req.setAttribute("detais", detai);
		
		if ((test1.compareTo(start) >= 0 && test1.compareTo(end) <= 0) || 
				(test1.compareTo(start2) >= 0 && test1.compareTo(end2)<=0) ) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/web/sinhvien/listdetai.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("views/web/sinhvien/khongcodotdangky.jsp");
			dispatcher.forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SinhVien sinhvien = new SinhVien();
		NhomSinhVien nhomsinhvien = new NhomSinhVien();
		DeTai detai = new DeTai();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				System.out.println(item);
				if (item.getFieldName().equals("ma_sinhvien")) {
					sinhvien.setMa_sinhvien(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("ma_detai")) {
					sinhvien.setMa_detai(Integer.parseInt(item.getString()));
					nhomsinhvien.setMa_detai(Integer.parseInt(item.getString()));
					detai.setMa_detai(Integer.parseInt(item.getString()));
				} else if (item.getFieldName().equals("truongnhom")) {
					nhomsinhvien.setTruongnhom(item.getString("UTF-8"));
				}
			}
			System.out.println(sinhvien.getMa_detai());
			System.out.println(sinhvien.getMa_sinhvien());
			System.out.println(nhomsinhvien.getTruongnhom());
			dangkys.studentRegister(nhomsinhvien);
			dangkys.insertSinhVien(sinhvien);
			dangkys.soluongSV(detai);
			HttpSession session = request.getSession(true);
			AccountDAO dao = new AccountDAO();
			SinhVien sv = dao.getSV(sinhvien.getMa_sinhvien());
			DeTai dt = dao.getDeTaiByMaDT(sv.getMa_detai());
			NhomSinhVien nsv = dao.getNSVByMaDT(sv.getMa_detai());
			Peoples truongnhom = dao.getSVById(nsv.getTruongnhom());
			Peoples gvhd = dao.getSVById(dt.getGvhd());
			Peoples gvpb = dao.getSVById(dt.getGvpb());
			session.setAttribute("sv", sv);
			session.setAttribute("truongnhom", truongnhom);
			session.setAttribute("gvhd", gvhd);
			session.setAttribute("gvpb", gvpb);
			session.setAttribute("dt", dt);
			response.sendRedirect(request.getContextPath() + "/svDKDT");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
