package com.Entity;

public class NhomSinhVien {
	private int ma_nhom;
	private String truongnhom;
	private String thanhvien;
	private int ma_detai;
	private String ngay_nopdetai;
	public NhomSinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhomSinhVien(int ma_nhom, String truongnhom, String thanhvien, int ma_detai,
			String ngay_nopdetai) {
		super();
		this.ma_nhom = ma_nhom;
		this.truongnhom = truongnhom;
		this.thanhvien = thanhvien;
		this.ma_detai = ma_detai;
		this.ngay_nopdetai = ngay_nopdetai;
	}
	public int getMa_nhom() {
		return ma_nhom;
	}
	public void setMa_nhom(int ma_nhom) {
		this.ma_nhom = ma_nhom;
	}
	public String getTruongnhom() {
		return truongnhom;
	}
	public void setTruongnhom(String truongnhom) {
		this.truongnhom = truongnhom;
	}
	public String getThanhvien() {
		return thanhvien;
	}
	public void setThanhvien(String thanhvien) {
		this.thanhvien = thanhvien;
	}
	public int getMa_detai() {
		return ma_detai;
	}
	public void setMa_detai(int ma_detai) {
		this.ma_detai = ma_detai;
	}
	public String getNgay_nopdetai() {
		return ngay_nopdetai;
	}
	public void setNgay_nopdetai(String ngay_nopdetai) {
		this.ngay_nopdetai = ngay_nopdetai;
	}
}
