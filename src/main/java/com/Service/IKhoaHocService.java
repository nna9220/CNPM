package com.Service;

import java.util.List;

import com.Entity.KhoaHoc;

public interface IKhoaHocService {
	void insert(KhoaHoc kh);
	List<KhoaHoc> getAll();
	KhoaHoc getById(int id);
	void delete(int ma_khoahoc);
	void edit(KhoaHoc kh);
}
