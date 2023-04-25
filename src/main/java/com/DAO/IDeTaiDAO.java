package com.DAO;

import java.util.List;

import com.Entity.DangKyGiangVien;
import com.Entity.DeTai;
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;

public interface IDeTaiDAO {
	void insert(DeTai detai);
	void delete(int ma_detai);
	void distributionTeacher(DeTai detai);//phân giảng viên phản biện 
	List<DeTai> detaiByGV(String id);
	DeTai get(int id);
	List<DeTai> getAll();
	List<DeTai> getAllAccess();
	Peoples getGV(String id);
	void accessDeTai(DeTai detai);//duyệt đề tài
	void studentRegister(NhomSinhVien nsv);
	void insertSinhVien(SinhVien sv);
	void soluongSV(DeTai dt);
	SinhVien getSV(String id);
	NhomSinhVien getManhomByDeTai(int ma_detai);
	void registerTopic(SinhVien sv);
	void studentRegister2(NhomSinhVien nsv, SinhVien sv, DeTai dt);
	List<DangKyGiangVien> getAllTimeGV();
	List<SinhVien> getAllSVAccess(int ma_detai);
	
}
