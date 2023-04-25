package com.Service.Impl;

import java.util.List;

import com.DAO.IDotDangKySinhVienDAO;
import com.DAO.Impl.DotDangKySinhVienImpl;
import com.Entity.DangKyGiangVien;
import com.Entity.DangKySinhVien;
import com.Service.IDotDangKySinhVienService;

public class DotDangKySinhVienServiceImpl implements IDotDangKySinhVienService {
	
	IDotDangKySinhVienDAO dangkyDAO = new DotDangKySinhVienImpl();
	@Override
	public void insert(DangKySinhVien dk) {
		dangkyDAO.insert(dk);
		
	}

	@Override
	public void edit(DangKySinhVien dk) {
		DangKySinhVien old = dangkyDAO.getById(dk.getId());
		old.setNgaybatdau(dk.getNgaybatdau());
		old.setNgayketthuc(dk.getNgayketthuc());
		dangkyDAO.edit(old);
		
	}

	@Override
	public List<DangKySinhVien> getAll() {
		return dangkyDAO.getAll();
	}

	@Override
	public DangKySinhVien getById(int id) {
		return dangkyDAO.getById(id);
	}

}
