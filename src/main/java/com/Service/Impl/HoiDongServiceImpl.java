package com.Service.Impl;

import java.util.List;

import com.DAO.IHoiDongDAO;
import com.DAO.Impl.HoiDongDAOImpl;
import com.Entity.GiangVien;
import com.Entity.HoiDong;
import com.Service.IHoiDongService;

public class HoiDongServiceImpl implements IHoiDongService {
	IHoiDongDAO hdDAO = new HoiDongDAOImpl();
	
	@Override
	public void insert1(HoiDong hd) {
		hdDAO.insert1(hd);
	}
	@Override
	public HoiDong getByIdDT(int id) {
		// TODO Auto-generated method stub
		return hdDAO.getByIdDT(id);
	}
	@Override
	public GiangVien getOne(String id) {
		// TODO Auto-generated method stub
		return hdDAO.getOne(id);
	}
	@Override
	public void insert2(HoiDong hd) {
		HoiDong old = hdDAO.getByIdDT(hd.getDetai());
		old.setGiangvien2(hd.getGiangvien2());
		hdDAO.insert2(old);
		
	}
	@Override
	public void insert3(HoiDong hd) {
		HoiDong old = hdDAO.getByIdDT(hd.getDetai());
		old.setGiangvien3(hd.getGiangvien3());
		hdDAO.insert3(old);
	}
	@Override
	public void insert4(HoiDong hd) {
		HoiDong old = hdDAO.getByIdDT(hd.getDetai());
		old.setGiangvien4(hd.getGiangvien4());
		hdDAO.insert4(old);
		
	}
	@Override
	public void insert5(HoiDong hd) {
		HoiDong old = hdDAO.getByIdDT(hd.getDetai());
		old.setGiangvien5(hd.getGiangvien5());
		hdDAO.insert5(old);
		
	}
	@Override
	public List<HoiDong> getByGV(String id) {
		// TODO Auto-generated method stub
		return hdDAO.getByGV(id);
	}

}
