package com.Service.Impl;

import java.util.List;

import com.DAO.IKhoaHocDAO;
import com.DAO.Impl.KhoaHocDAOImpl;
import com.Entity.KhoaHoc;
import com.Service.IKhoaHocService;

public class KhoaHocServiceImpl implements IKhoaHocService {
	IKhoaHocDAO khDAO = new KhoaHocDAOImpl();
	@Override
	public List<KhoaHoc> getAll() {
		// TODO Auto-generated method stub
		return khDAO.getAll();
	}

	@Override
	public KhoaHoc getById(int id) {
		// TODO Auto-generated method stub
		return khDAO.getById(id);
	}

	@Override
	public void insert(KhoaHoc kh) {
		khDAO.insert(kh);
		
	}

	@Override
	public void delete(int ma_khoahoc) {
		khDAO.delete(ma_khoahoc);
		
	}

	@Override
	public void edit(KhoaHoc kh) {
		KhoaHoc old = khDAO.getById(kh.getMa_khoahoc());
		old.setCtdt(kh.getCtdt());
		khDAO.edit(old);
		
	}

}
