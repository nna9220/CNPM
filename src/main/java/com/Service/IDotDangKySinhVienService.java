package com.Service;

import java.util.List;

import com.Entity.DangKySinhVien;

public interface IDotDangKySinhVienService {
	void insert(DangKySinhVien dk);
	void edit(DangKySinhVien dk);
	List<DangKySinhVien> getAll();
	DangKySinhVien getById(int id);
}
