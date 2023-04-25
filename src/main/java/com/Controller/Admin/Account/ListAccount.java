package com.Controller.Admin.Account;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AccountDAO;
import com.Entity.Accounts;
@WebServlet(urlPatterns = {"/AccountList"})
public class ListAccount extends HttpServlet {

	private static final long serialVersionUID = 1L;
	AccountDAO acc = new AccountDAO();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Accounts> svList = acc.getAllAccount();
		req.setAttribute("svList", svList);
		RequestDispatcher dispatcher =
		req.getRequestDispatcher("/views/admin/Account/Account-list.jsp");
		dispatcher.forward(req, resp);
	
}
}
