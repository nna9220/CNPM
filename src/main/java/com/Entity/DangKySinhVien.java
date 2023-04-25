package com.Entity;

public class DangKySinhVien {
	private int id;
	private String ngaybatdau;
	private String ngayketthuc;
	public DangKySinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DangKySinhVien(int id, String ngaybatdau, String ngayketthuc) {
		super();
		this.id = id;
		this.ngaybatdau = ngaybatdau;
		this.ngayketthuc = ngayketthuc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNgaybatdau() {
		return ngaybatdau;
	}
	public void setNgaybatdau(String ngaybatdau) {
		this.ngaybatdau = ngaybatdau;
	}
	public String getNgayketthuc() {
		return ngayketthuc;
	}
	public void setNgayketthuc(String ngayketthuc) {
		this.ngayketthuc = ngayketthuc;
	}
}
