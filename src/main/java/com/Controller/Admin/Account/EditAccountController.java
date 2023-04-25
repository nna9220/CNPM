package com.Controller.Admin.Account;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Entity.Accounts;
import com.Service.IAccountService;
import com.Service.Impl.AccountServiceImpl;


@WebServlet(urlPatterns = {"/editAccount"})
public class EditAccountController extends HttpServlet {
	IAccountService accounts = new AccountServiceImpl();
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println(id);
		Accounts account = accounts.get(id);
		req.setAttribute("account", account);
		RequestDispatcher dispatcher = req.getRequestDispatcher("views/admin/Account/editAccount.jsp");
		dispatcher.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Accounts account = new Accounts();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);

			for (FileItem item : items) {
				System.out.println("item:" + item.getFieldName());
				
				if (item.getFieldName().equals("id")) {
					account.setUsername(item.getString("UTF-8"));
				}
				else if (item.getFieldName().equals("password")) {
					account.setPassword(item.getString("UTF-8"));
				}
			accounts.edit(account);
			resp.sendRedirect(req.getContextPath() + "/AccountList");
		}
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}
}
