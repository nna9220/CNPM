package com.DAO;


import java.util.List;

import com.Entity.GiangVien;
import com.Entity.HoiDong;

public interface IHoiDongDAO {
	void insert1(HoiDong hd);
	void insert2(HoiDong hd);
	void insert3(HoiDong hd);
	void insert4(HoiDong hd);
	void insert5(HoiDong hd);
	HoiDong getByIdDT(int id);
	GiangVien getOne(String id);
	List<HoiDong> getByGV(String id);
}
