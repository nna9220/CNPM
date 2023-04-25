package com.Entity;

public class GiangVien {
	private String ma_giangvien, chucvu;
	private int hoidong;
	public GiangVien() {
		super();
	}
	public GiangVien(String ma_giangvien, String chucvu, int hoidong) {
		super();
		this.ma_giangvien = ma_giangvien;
		this.chucvu = chucvu;
		this.hoidong = hoidong;
	}
	public String getMa_giangvien() {
		return ma_giangvien;
	}
	public void setMa_giangvien(String ma_giangvien) {
		this.ma_giangvien = ma_giangvien;
	}
	public int getHoidong() {
		return hoidong;
	}
	public void setHoidong(int hoidong) {
		this.hoidong = hoidong;
	}
	public String getChucvu() {
		return chucvu;
	}
	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}
	
}
