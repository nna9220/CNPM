package com.Entity;

public class ChuyenNganh {
	private int ma_chuyennganh;
	private String ten_chuyennganh;
	public ChuyenNganh() {
		super();
	}
	public ChuyenNganh(int ma_chuyennganh, String ten_chuyennganh) {
		super();
		this.ma_chuyennganh = ma_chuyennganh;
		this.ten_chuyennganh = ten_chuyennganh;
	}
	public int getMa_chuyennganh() {
		return ma_chuyennganh;
	}
	public void setMa_chuyennganh(int ma_chuyennganh) {
		this.ma_chuyennganh = ma_chuyennganh;
	}
	public String getTen_chuyennganh() {
		return ten_chuyennganh;
	}
	public void setTen_chuyennganh(String ten_chuyennganh) {
		this.ten_chuyennganh = ten_chuyennganh;
	}
	
}
