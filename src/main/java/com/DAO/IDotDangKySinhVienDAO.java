package com.DAO;

import java.util.List;

import com.Entity.DangKySinhVien;

public interface IDotDangKySinhVienDAO {
	void insert(DangKySinhVien dk);
	void edit(DangKySinhVien dk);
	List<DangKySinhVien> getAll();
	DangKySinhVien getById(int id);
}
