package com.Service;

import java.util.List;

import com.Entity.Peoples;
import com.Entity.GiangVien;

public interface IGiangVienService {
	void insert(Peoples pp, GiangVien gv);
	void edit(Peoples gv);
	void delete(String id);
	Peoples get(String id);
	List<Peoples> getAll();
	List<Peoples> search(String key);
	GiangVien getGV(String id);
}
