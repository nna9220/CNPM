package com.Controller.Admin.KhoaHoc;

import java.awt.Frame;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.IKhoaHocService;
import com.Service.Impl.KhoaHocServiceImpl;

@WebServlet(urlPatterns = { "/DeleteKhoahoc" })
public class DeleteKhoaHocController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IKhoaHocService khoahocs = new KhoaHocServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		khoahocs.delete(Integer.parseInt(req.getParameter("id")));
		try {
			resp.sendRedirect(req.getContextPath() + "/listKhoahoc");
		}catch(Exception e){
		}
	}

}
