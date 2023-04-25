package com.Controller.Web.GiangVien;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Accounts;
import com.Entity.DeTai;
import com.Entity.GiangVien;
import com.Entity.HoiDong;
import com.Entity.Peoples;
import com.Service.IDeTaiService;
import com.Service.IGiangVienService;
import com.Service.IHoiDongService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.GiangienServiceImpl;
import com.Service.Impl.HoiDongServiceImpl;
@WebServlet(urlPatterns = {"/detailHoiDong"})
public class DetailHoiDongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IHoiDongService hoidongs = new HoiDongServiceImpl();
	IGiangVienService gvs = new GiangienServiceImpl();
	IDeTaiService dts = new DeTaiServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		HoiDong hd = hoidongs.getByIdDT(Integer.parseInt(id));
		DeTai dt = dts.get(hd.getDetai());
		Peoples gv1 = gvs.get(hd.getGiangvien1());
		Peoples gv2 = gvs.get(hd.getGiangvien2());
		Peoples gv3 = gvs.get(hd.getGiangvien3());
		Peoples gv4 = gvs.get(hd.getGiangvien4());
		Peoples gv5 = gvs.get(hd.getGiangvien5());
		Peoples gvhd = gvs.get(dt.getGvhd());
		Peoples gvpb = gvs.get(dt.getGvpb());
		req.setAttribute("dt", dt);
		req.setAttribute("gv1", gv1);
		req.setAttribute("gv2", gv2);
		req.setAttribute("gv3", gv3);
		req.setAttribute("gv4", gv4);
		req.setAttribute("gv5", gv5);
		req.setAttribute("gvhd", gvhd);
		req.setAttribute("gvpb", gvpb);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/web/giangvien/detailHoiDong.jsp");
		dispatcher.forward(req, resp);
	}
	

}
