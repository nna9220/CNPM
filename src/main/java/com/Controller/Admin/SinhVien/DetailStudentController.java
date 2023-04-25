package com.Controller.Admin.SinhVien;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Accounts;
import com.Entity.DeTai;
import com.Entity.KhoaHoc;
import com.Entity.Peoples;
import com.Entity.SinhVien;
import com.Service.IDeTaiService;
import com.Service.ISinhVienService;
import com.Service.Impl.DeTaiServiceImpl;
import com.Service.Impl.SinhVienServiceImpl;
@WebServlet(urlPatterns = {"/detailStudent"})
public class DetailStudentController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	ISinhVienService sinhvien = new SinhVienServiceImpl();
	IDeTaiService detai = new DeTaiServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		SinhVien sv = sinhvien.getSV(id);
		Peoples people = sinhvien.get(id);
		Accounts acc =  sinhvien.getAcc(people.getEmail());
		KhoaHoc khoa = sinhvien.getK(sv.getKhoa());
		DeTai dt = detai.get(sv.getMa_detai());
		System.out.println(khoa.getCtdt());
		req.setAttribute("pp", sv);
		req.setAttribute("sv", people);
		req.setAttribute("khoa", khoa);
		req.setAttribute("acc", acc);
		req.setAttribute("dt", dt);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/SinhVien/detailSinhVien.jsp");
		dispatcher.forward(req, resp);
	}
	

}
