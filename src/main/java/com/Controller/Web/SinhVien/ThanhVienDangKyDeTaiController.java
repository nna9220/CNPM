package com.Controller.Web.SinhVien;

import java.io.IOException;
import java.util.List;

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
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;
import com.Service.IDeTaiService;
import com.Service.Impl.DeTaiServiceImpl;
@WebServlet(urlPatterns = {"/thanhvienDKDT"})
public class ThanhVienDangKyDeTaiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IDeTaiService dangkys = new DeTaiServiceImpl();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SinhVien sinhvien = new SinhVien();
		NhomSinhVien nhomsinhvien = new NhomSinhVien();
		DeTai detai= new DeTai();
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
					nhomsinhvien.setThanhvien(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("ma_detai")) {
					sinhvien.setMa_detai(Integer.parseInt(item.getString()));
					nhomsinhvien.setMa_detai(Integer.parseInt(item.getString()));
					detai.setMa_detai(Integer.parseInt(item.getString()));
				}
			}
			System.out.println(sinhvien.getMa_detai());
			System.out.println(sinhvien.getMa_sinhvien());
			System.out.println(nhomsinhvien.getThanhvien());
			dangkys.studentRegister2(nhomsinhvien, sinhvien, detai);
			HttpSession session = request.getSession(true);
			AccountDAO dao = new AccountDAO();
			List<SinhVien> listsv = dangkys.getAllSVAccess(sinhvien.getMa_detai());
			SinhVien sv = dao.getSV(sinhvien.getMa_sinhvien());
			DeTai dt = dao.getDeTaiByMaDT(sv.getMa_detai());
			NhomSinhVien nsv = dao.getNSVByMaDT(sv.getMa_detai());
			Peoples truongnhom = dao.getSVById(nsv.getTruongnhom());
			Peoples gvhd = dao.getSVById(dt.getGvhd());
			Peoples gvpb = dao.getSVById(dt.getGvpb());
			session.setAttribute("nsv", nsv);
			session.setAttribute("sv", sv);
			session.setAttribute("truongnhom", truongnhom);
			session.setAttribute("listsv", listsv);
			session.setAttribute("gvhd", gvhd);
			session.setAttribute("gvpb", gvpb);
			session.setAttribute("dt", dt);
			response.sendRedirect(request.getContextPath() + "/svDKDT");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
