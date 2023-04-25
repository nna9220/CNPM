package com.Controller.Web.GiangVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.HoiDong;
import com.Service.IHoiDongService;
import com.Service.Impl.HoiDongServiceImpl;
@WebServlet(urlPatterns = {"/hoidong"})
public class HoiDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IHoiDongService hoidongs = new HoiDongServiceImpl();
		List<HoiDong> hds = hoidongs.getByGV(req.getParameter("id"));
		req.setAttribute("hds", hds);
		req.getRequestDispatcher("/views/web/giangvien/hoidong.jsp").forward(req, resp);
	}
	

}
