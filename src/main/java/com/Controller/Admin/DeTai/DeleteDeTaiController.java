package com.Controller.Admin.DeTai;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Service.IDeTaiService;
import com.Service.Impl.DeTaiServiceImpl;
@WebServlet(urlPatterns = {"/DeleteDetai"})
public class DeleteDeTaiController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	IDeTaiService detais = new DeTaiServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		detais.delete(Integer.parseInt(req.getParameter("id")));
		resp.sendRedirect(req.getContextPath() + "/listDetai");
	}
	

}
