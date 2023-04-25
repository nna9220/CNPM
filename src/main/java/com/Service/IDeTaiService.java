package com.Service;

import java.util.List;

import com.Entity.DangKyGiangVien;
import com.Entity.DeTai;
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;

public interface IDeTaiService {
	void insert(DeTai detai);
	void delete(int ma_detai);
	List<DeTai> detaiByGV(String id);
	void distributionTeacher(DeTai detai);
	//thanhf vieen dk
	void registerTopic(SinhVien sv);
	DeTai get(int id);
	List<DeTai> getAll();
	List<DeTai> getAllAccess();
	Peoples getGV(String id);
	void accessDeTai(DeTai detai);
	SinhVien getSV(String id);
	void studentRegister(NhomSinhVien nsv);
	void studentRegister2(NhomSinhVien nsv, SinhVien sv, DeTai dt); //truongnhom xac nhan
	void insertSinhVien(SinhVien sv);
	void soluongSV(DeTai dt);
	List<DangKyGiangVien> getAllTimeGV();
	List<SinhVien> getAllSVAccess(int ma_detai);
}
