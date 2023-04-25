package com.DAO;

import java.util.List;

import com.Entity.GiangVien;
import com.Entity.Peoples;

public interface IGiangVienDAO {
	void insert(Peoples pp, GiangVien gv);
	void edit(Peoples gv);
	void delete(String id);
	Peoples get(String id);
	GiangVien getGV(String id);
	List<Peoples> getAll();
	List<Peoples> search(String key);
}
