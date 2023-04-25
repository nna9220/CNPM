package com.Entity;

public class SinhVien {
	private String ma_sinhvien;
    private int khoa;
    private int ma_detai;
    private int diem_pb;
    private int statusdetai;
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SinhVien(String ma_sinhvien, int khoa, int ma_detai, int diem_pb, int statusdetai) {
		super();
		this.ma_sinhvien = ma_sinhvien;
		this.khoa = khoa;
		this.ma_detai = ma_detai;
		this.diem_pb = diem_pb;
		this.statusdetai = statusdetai;
	}
	public int getStatusdetai() {
		return statusdetai;
	}
	public void setStatusdetai(int statusdetai) {
		this.statusdetai = statusdetai;
	}
	public String getMa_sinhvien() {
		return ma_sinhvien;
	}
	public void setMa_sinhvien(String ma_sinhvien) {
		this.ma_sinhvien = ma_sinhvien;
	}
	public int getKhoa() {
		return khoa;
	}
	public void setKhoa(int khoa) {
		this.khoa = khoa;
	}
	public int getMa_detai() {
		return ma_detai;
	}
	public void setMa_detai(int ma_detai) {
		this.ma_detai = ma_detai;
	}
	public int getDiem_pb() {
		return diem_pb;
	}
	public void setDiem_pb(int diem_pb) {
		this.diem_pb = diem_pb;
	}
}
