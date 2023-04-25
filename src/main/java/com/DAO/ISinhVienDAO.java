package com.DAO;

import java.util.List;

import com.Entity.Accounts;
import com.Entity.KhoaHoc;
import com.Entity.Peoples;
import com.Entity.SinhVien;

public interface ISinhVienDAO {
	void insert(Peoples pp, SinhVien sv);
	void edit(Peoples sv);
	void delete(String id, String email);
	void addAcc(Accounts acc);
	KhoaHoc getK(int khoa);
	Peoples get(String id);
	Peoples getByEmail(String email);
	Accounts getAcc(String email);
	SinhVien getSV(String id);
	List<Peoples> getAll();
	List<Peoples> search(String key);
}
