package com.DAO;

import java.util.List;

import com.Entity.DangKyGiangVien;

public interface IDotDangKyGiangVienDAO {
	void insert(DangKyGiangVien dk);
	void edit(DangKyGiangVien dk);
	List<DangKyGiangVien> getAll();
	DangKyGiangVien getById(int id);
}
