package com.Controller.Admin.HoiDong;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.Entity.HoiDong;
import com.Service.IHoiDongService;
import com.Service.Impl.HoiDongServiceImpl;
@WebServlet(urlPatterns = {"/taohoidong2"})
public class InsertGiangVien2Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IHoiDongService hoidongs = new HoiDongServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HoiDong hoidong = new HoiDong();
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		servletFileUpload.setHeaderEncoding("UTF-8");
		try {
			resp.setContentType("text/html");
			resp.setCharacterEncoding("UTF-8");
			req.setCharacterEncoding("UTF-8");
			List<FileItem> items = servletFileUpload.parseRequest(req);
			for (FileItem item : items) {
				System.out.println(item);
				if (item.getFieldName().equals("ma_giangvien")) {
					hoidong.setGiangvien2(item.getString("UTF-8"));
				} else if (item.getFieldName().equals("ma_detai")) {
					hoidong.setDetai(Integer.parseInt(item.getString()));
				} 
			}
			System.out.println("Mã" +hoidong.getMa_hd());
			hoidongs.insert2(hoidong);
			System.out.println("Mã" +hoidong.getGiangvien2());
			resp.sendRedirect(req.getContextPath() + "/taohoidong?id=" +hoidong.getDetai());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
