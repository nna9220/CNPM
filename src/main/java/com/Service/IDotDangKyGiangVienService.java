package com.Service;

import java.util.List;

import com.Entity.DangKyGiangVien;

public interface IDotDangKyGiangVienService {
	void insert(DangKyGiangVien dk);
	void edit(DangKyGiangVien dk);
	List<DangKyGiangVien> getAll();
	DangKyGiangVien getById(int id);
}
