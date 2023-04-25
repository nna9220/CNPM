package com.Service.Impl;

import java.util.List;

import com.DAO.IGiangVienDAO;
import com.DAO.Impl.GiangVienDAOImpl;
import com.Entity.GiangVien;
import com.Entity.Peoples;
import com.Service.IGiangVienService;

public class GiangienServiceImpl implements IGiangVienService {
	IGiangVienDAO gvDAO = new GiangVienDAOImpl();

	@Override
	public void insert(Peoples pp, GiangVien gv) {
		gvDAO.insert(pp, gv);
		
	}

	@Override
	public void edit(Peoples gv) {
		Peoples old = gvDAO.get(gv.getId());
		old.setHoten(gv.getHoten());
//		old.setNgaysinh(sv.getNgaysinh());
//		old.setGioitinh(sv.getGioitinh());
//		old.setDiachi(sv.getDiachi());
//		old.setSdt(sv.getSdt());
//		old.setEmail(sv.getEmail());
		gvDAO.edit(old);
		
	}

	@Override
	public void delete(String id) {
		gvDAO.delete(id);
		
	}

	@Override
	public List<Peoples> getAll() {
		return gvDAO.getAll();
	}

	@Override
	public Peoples get(String id) {
		// TODO Auto-generated method stub
		return gvDAO.get(id);
	}

	@Override
	public List<Peoples> search(String key) {
		// TODO Auto-generated method stub
		return gvDAO.search(key);
	}

	@Override
	public GiangVien getGV(String id) {
		// TODO Auto-generated method stub
		return gvDAO.getGV(id);
	}

}
