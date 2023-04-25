package com.Service.Impl;

import java.util.List;

import com.DAO.IDeTaiDAO;
import com.DAO.ISinhVienDAO;
import com.DAO.Impl.DeTaiDAOImpl;
import com.DAO.Impl.SinhVienDAOImpl;
import com.Entity.Accounts;
import com.Entity.DangKyGiangVien;
import com.Entity.DeTai;
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;
import com.Service.IDeTaiService;

public class DeTaiServiceImpl implements IDeTaiService {
	IDeTaiDAO detaiDAO = new DeTaiDAOImpl();
	ISinhVienDAO svDAO = new SinhVienDAOImpl();
	@Override
	public void insert(DeTai detai) {
		detaiDAO.insert(detai);
		
	}
	@Override
	public List<DeTai> detaiByGV(String id) {
		// TODO Auto-generated method stub
		return detaiDAO.detaiByGV(id);
	}
	@Override
	public void distributionTeacher(DeTai detai) {
		DeTai old = detaiDAO.get(detai.getMa_detai());
		old.setGvpb(detai.getGvpb());
		detaiDAO.distributionTeacher(old);
		
	}
	@Override
	public DeTai get(int id) {
		// TODO Auto-generated method stub
		return detaiDAO.get(id);
	}
	@Override
	public List<DeTai> getAll() {
		// TODO Auto-generated method stub
		return detaiDAO.getAll();
	}
	@Override
	public Peoples getGV(String id) {
		// TODO Auto-generated method stub
		return detaiDAO.getGV(id);
	}
	@Override
	public void accessDeTai(DeTai detai) {
		DeTai old = detaiDAO.get(detai.getMa_detai());
		old.setTrangthai(detai.getTrangthai());
		detaiDAO.accessDeTai(old);
	}
	@Override
	public void studentRegister(NhomSinhVien nsv) {
		detaiDAO.studentRegister(nsv);
	}
	@Override
	public SinhVien getSV(String id) {
		// TODO Auto-generated method stub
		return detaiDAO.getSV(id);
	}
	@Override
	public void insertSinhVien(SinhVien sv) {
		SinhVien SVold = detaiDAO.getSV(sv.getMa_sinhvien());
		SVold.setMa_detai(sv.getMa_detai());
		SVold.setStatusdetai(sv.getStatusdetai());
		detaiDAO.insertSinhVien(SVold);
	}
	@Override
	public void soluongSV(DeTai dt) {
		DeTai old = detaiDAO.get(dt.getMa_detai());
		old.setSoluongsinhviendangky(dt.getSoluongsinhviendangky());
		detaiDAO.soluongSV(old);
	}
	@Override
	public void studentRegister2(NhomSinhVien nsv, SinhVien sv, DeTai dt) {
		SinhVien SVold = detaiDAO.getSV(sv.getMa_sinhvien());
		SVold.setMa_detai(sv.getMa_detai());
		SVold.setStatusdetai(sv.getStatusdetai());
		DeTai old = detaiDAO.get(dt.getMa_detai());
		old.setSoluongsinhviendangky(dt.getSoluongsinhviendangky());
		NhomSinhVien nsvOld = detaiDAO.getManhomByDeTai(nsv.getMa_detai());
		nsvOld.setThanhvien(nsv.getThanhvien());
		detaiDAO.studentRegister2(nsv, SVold, old);
		
	}
	@Override
	public List<DangKyGiangVien> getAllTimeGV() {
		// TODO Auto-generated method stub
		return detaiDAO.getAllTimeGV();
	}
	@Override
	public List<DeTai> getAllAccess() {
		// TODO Auto-generated method stub
		return detaiDAO.getAllAccess();
	}
	@Override
	public void delete(int ma_detai) {
		detaiDAO.delete(ma_detai);
	}
	@Override
	public List<SinhVien> getAllSVAccess(int ma_detai) {
		// TODO Auto-generated method stub
		return detaiDAO.getAllSVAccess(ma_detai);
	}
	@Override
	public void registerTopic(SinhVien sv) {
		SinhVien old = detaiDAO.getSV(sv.getMa_sinhvien());
		old.setStatusdetai(sv.getStatusdetai());
		old.setMa_detai(sv.getMa_detai());
		detaiDAO.registerTopic(old);
		
	}
}
