package com.Controller.Admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AccountDAO;
import com.Entity.Accounts;
import com.Entity.DeTai;
import com.Entity.HoiDong;
import com.Entity.KhoaHoc;
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;
import com.Service.IDeTaiService;
import com.Service.IHoiDongService;
import com.Service.IKhoaHocService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.HoiDongServiceImpl;
import com.Service.Impl.KhoaHocServiceImpl;

@WebServlet(urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 114145753183079163L;
	public static final String SUCCESS = "Home";
	public static final String SUCCESSADMIN = "Admin";
	public static final String ERROR = "Invalid";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/loginPage.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		HttpSession session = req.getSession(true);
		String url = ERROR;
		try {
			String username = req.getParameter("txtUsername");
			String password = req.getParameter("txtPassword");

			AccountDAO dao = new AccountDAO();
			IKhoaHocService khoahoc = new KhoaHocServiceImpl();
			Accounts user = dao.checkLogin(username, password);
			List<Peoples> gv = dao.getAll();
			int role = user.getRoleid();
			Peoples peoples = dao.getEmail(username);
			session.setAttribute("gv", gv);
			session.setAttribute("info", peoples);
			session.setAttribute("USER", user);
			session.setAttribute("role", role);
			if (user.getRoleid() == 1) {
				url = SUCCESSADMIN;
			} else if (user.getRoleid() == 4 || user.getRoleid() == 2 || user.getRoleid() == 3) {
				url = SUCCESS;
				if(user.getRoleid() == 4) {
					IDeTaiService dangkys = new DeTaiServiceImpl();
					
					SinhVien sv = dao.getSV(peoples.getId());
					DeTai dt = dao.getDeTaiByMaDT(sv.getMa_detai());
					NhomSinhVien nsv = dao.getNSVByMaDT(sv.getMa_detai());
					Peoples truongnhom = dao.getSVById(nsv.getTruongnhom());
					Peoples thanhvien = dao.getSVById(nsv.getThanhvien());
					Peoples gvhd = dao.getSVById(dt.getGvhd());
					Peoples gvpb = dao.getSVById(dt.getGvpb());
					KhoaHoc kh = khoahoc.getById(sv.getKhoa());
					List<SinhVien> listsv = dangkys.getAllSVAccess(sv.getMa_detai());
					session.setAttribute("sv", sv);
					session.setAttribute("truongnhom", truongnhom);
					session.setAttribute("thanhvien", thanhvien);
					session.setAttribute("listsv", listsv);
					session.setAttribute("gvhd", gvhd);
					session.setAttribute("gvpb", gvpb);
					session.setAttribute("dt", dt);
					session.setAttribute("kh", kh);
					session.setAttribute("nsv", nsv);
				}
			}
		} catch (Exception e) {
			log("error at login servlet: " + e.toString());
		}

		resp.sendRedirect(url);
	}
}
