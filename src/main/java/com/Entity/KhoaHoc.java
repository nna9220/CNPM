package com.Entity;

public class KhoaHoc {
	private int ma_khoahoc;
	private String ten_khoahoc;
	private String nienkhoa;
	private String nam_nhaphoc;
	private String nam_ketthuc;
	private String ctdt;
	private String lopsinhvien;
	public KhoaHoc() {
		super();
	}
	public KhoaHoc(int ma_khoahoc, String ten_khoahoc, String nienkhoa, String nam_nhaphoc, String nam_ketthuc,
			String ctdt, String lopsinhvien) {
		super();
		this.ma_khoahoc = ma_khoahoc;
		this.ten_khoahoc = ten_khoahoc;
		this.nienkhoa = nienkhoa;
		this.nam_nhaphoc = nam_nhaphoc;
		this.nam_ketthuc = nam_ketthuc;
		this.ctdt = ctdt;
		this.lopsinhvien = lopsinhvien;
	}
	public int getMa_khoahoc() {
		return ma_khoahoc;
	}
	public void setMa_khoahoc(int ma_khoahoc) {
		this.ma_khoahoc = ma_khoahoc;
	}
	public String getTen_khoahoc() {
		return ten_khoahoc;
	}
	public void setTen_khoahoc(String ten_khoahoc) {
		this.ten_khoahoc = ten_khoahoc;
	}
	public String getNienkhoa() {
		return nienkhoa;
	}
	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}
	public String getNam_nhaphoc() {
		return nam_nhaphoc;
	}
	public void setNam_nhaphoc(String nam_nhaphoc) {
		this.nam_nhaphoc = nam_nhaphoc;
	}
	public String getNam_ketthuc() {
		return nam_ketthuc;
	}
	public void setNam_ketthuc(String nam_ketthuc) {
		this.nam_ketthuc = nam_ketthuc;
	}
	public String getCtdt() {
		return ctdt;
	}
	public void setCtdt(String ctdt) {
		this.ctdt = ctdt;
	}
	public String getLopsinhvien() {
		return lopsinhvien;
	}
	public void setLopsinhvien(String lopsinhvien) {
		this.lopsinhvien = lopsinhvien;
	}
	
}
