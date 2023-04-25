package com.Service.Impl;

import java.util.List;

import com.DAO.IDotDangKyGiangVienDAO;
import com.DAO.Impl.DotDangKyGiangVienDAOImpl;
import com.Entity.DangKyGiangVien;
import com.Service.IDotDangKyGiangVienService;

public class DotDangKyGiangVienServiceImpl implements IDotDangKyGiangVienService {
	IDotDangKyGiangVienDAO dangkyDAO = new DotDangKyGiangVienDAOImpl();
	@Override
	public void insert(DangKyGiangVien dk) {
		dangkyDAO.insert(dk);
	}

	@Override
	public void edit(DangKyGiangVien dk) {
		DangKyGiangVien old = dangkyDAO.getById(dk.getId());
		old.setNgaybatdau(dk.getNgaybatdau());
		old.setNgayketthuc(dk.getNgayketthuc());
		dangkyDAO.edit(old);
	}

	@Override
	public List<DangKyGiangVien> getAll() {
		// TODO Auto-generated method stub
		return dangkyDAO.getAll();
	}

	@Override
	public DangKyGiangVien getById(int id) {
		// TODO Auto-generated method stub
		return dangkyDAO.getById(id);
	}

}
