package com.Controller.Admin.GiangVien;

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
import com.Entity.Peoples;
import com.Service.IDeTaiService;
import com.Service.IGiangVienService;
import com.Service.ISinhVienService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.GiangienServiceImpl;
import com.Service.Impl.SinhVienServiceImpl;
@WebServlet(urlPatterns = {"/detailTeacher"})
public class DetailTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ISinhVienService sinhvien = new SinhVienServiceImpl();
	IGiangVienService giangvien = new GiangienServiceImpl();
	IDeTaiService detais = new DeTaiServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		GiangVien gv = giangvien.getGV(id);
		Peoples people = sinhvien.get(id);
		Accounts acc =  sinhvien.getAcc(people.getEmail());
		List<DeTai> detai = detais.detaiByGV(id);
		req.setAttribute("pp", gv);
		req.setAttribute("sv", people);
		req.setAttribute("acc", acc);
		req.setAttribute("dts", detai);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/GiangVien/detailTeacher.jsp");
		dispatcher.forward(req, resp);
	}

}
