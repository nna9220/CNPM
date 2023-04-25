package com.Controller.Admin.Account;

import java.io.Console;
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

@WebServlet(urlPatterns = {"/AddAccount"})
public class AddAccountController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	IAccountService account = new AccountServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher =
				req.getRequestDispatcher("/views/admin/Account/addAccount.jsp");
				dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Accounts acc =  new Accounts();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(request);
			for (FileItem item : items) {
				if (item.getFieldName().equals("username")) {
					acc.setUsername(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("password")) {
					acc.setPassword(item.getString("UTF-8"));
				}
				else if(item.getFieldName().equals("roleid")) {
					acc.setRoleid(Integer.parseInt(item.getString()));
				}
			}
			System.out.println(acc.getUsername());
			account.insert(acc);
			response.sendRedirect(request.getContextPath() + "/AccountList");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
