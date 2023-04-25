package com.Service.Impl;

import java.util.List;

import com.DAO.ISinhVienDAO;
import com.DAO.Impl.SinhVienDAOImpl;
import com.Entity.Accounts;
import com.Entity.KhoaHoc;
import com.Entity.Peoples;
import com.Entity.SinhVien;
import com.Service.ISinhVienService;

public class SinhVienServiceImpl implements ISinhVienService {
	ISinhVienDAO svDAO = new SinhVienDAOImpl();
	@Override
	public Peoples get(String id) {
		// TODO Auto-generated method stub
		return svDAO.get(id);
	}
	@Override
	public void insert(Peoples pp, SinhVien sv) {
		svDAO.insert(pp, sv);
	}

	//ServiceImpl
	@Override
	public void edit(Peoples sv) {
		Peoples old = svDAO.get(sv.getId());
		old.setHoten(sv.getHoten());
//		old.setNgaysinh(sv.getNgaysinh());
//		old.setGioitinh(sv.getGioitinh());
//		old.setDiachi(sv.getDiachi());
//		old.setSdt(sv.getSdt());
//		old.setEmail(sv.getEmail());
		svDAO.edit(old);
	}

	@Override
	public void delete(String id, String email) {
		svDAO.delete(id, email);
		
	}

	@Override
	public List<Peoples> getAll() {
		return svDAO.getAll();
	}
	@Override
	public SinhVien getSV(String id) {
		// TODO Auto-generated method stub
		return svDAO.getSV(id);
	}
	@Override
	public Accounts getAcc(String email) {
		// TODO Auto-generated method stub
		return svDAO.getAcc(email);
	}
	@Override
	public void addAcc(Accounts acc) {
		svDAO.addAcc(acc);
	}
	@Override
	public KhoaHoc getK(int khoa) {
		// TODO Auto-generated method stub
		return svDAO.getK(khoa);
	}
	@Override
	public List<Peoples> search(String key) {
		// TODO Auto-generated method stub
		return svDAO.search(key);
	}
	@Override
	public Peoples getByEmail(String email) {
		// TODO Auto-generated method stub
		return svDAO.getByEmail(email);
	}
	

	

	
}
