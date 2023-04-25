package com.Entity;

public class Peoples {
	private String id;
	private String hoten;
	private String ngaysinh;
	private int gioitinh;
	private String diachi;
	private String sdt;
	private String email;
	private int ma_chuyennganh;
	private int roleid;
	public Peoples() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Peoples(String id, String hoten, String ngaysinh, int gioitinh, String diachi, String sdt, String email,
			int ma_chuyennganh, int roleid) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.gioitinh = gioitinh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.ma_chuyennganh = ma_chuyennganh;
		this.roleid = roleid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public int getGioitinh() {
		return gioitinh;
	}
	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getMa_chuyennganh() {
		return ma_chuyennganh;
	}
	public void setMa_chuyennganh(int ma_chuyennganh) {
		this.ma_chuyennganh = ma_chuyennganh;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

}
