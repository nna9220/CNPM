package com.DAO;

import java.util.List;

import com.Entity.KhoaHoc;

public interface IKhoaHocDAO {
	List<KhoaHoc> getAll();
	KhoaHoc getById(int id);
	void insert(KhoaHoc kh);
	void delete(int ma_khoahoc);
	void edit(KhoaHoc kh);
}
