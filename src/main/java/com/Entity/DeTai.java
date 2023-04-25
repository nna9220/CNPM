package com.Entity;

public class DeTai {
	private int ma_detai;
	private String ten_detai;
    private int ma_chuyennganh;
    private String gvhd;
    private String gvpb;
    private int trangthai;
    private int nam_totnghiep;
    private int soluongsinhviendangky;
    private int dotdangky;
	public DeTai() {
		super();
	}
	public DeTai(int ma_detai, String ten_detai, int ma_chuyennganh, String gvhd, String gvpb, int trangthai, int nam_totnghiep,
			int soluongsinhviendangky, int dotdangky) {
		super();
		this.ma_detai = ma_detai;
		this.ten_detai = ten_detai;
		this.ma_chuyennganh = ma_chuyennganh;
		this.gvhd = gvhd;
		this.gvpb = gvpb;
		this.trangthai = trangthai;
		this.nam_totnghiep = nam_totnghiep;
		this.soluongsinhviendangky = soluongsinhviendangky;
		this.dotdangky = dotdangky;
	}
	public int getDotdangky() {
		return dotdangky;
	}
	public void setDotdangky(int dotdangky) {
		this.dotdangky = dotdangky;
	}
	public int getMa_detai() {
		return ma_detai;
	}
	public void setMa_detai(int ma_detai) {
		this.ma_detai = ma_detai;
	}
	public String getTen_detai() {
		return ten_detai;
	}
	public void setTen_detai(String ten_detai) {
		this.ten_detai = ten_detai;
	}
	public int getMa_chuyennganh() {
		return ma_chuyennganh;
	}
	public void setMa_chuyennganh(int ma_chuyennganh) {
		this.ma_chuyennganh = ma_chuyennganh;
	}
	public String getGvhd() {
		return gvhd;
	}
	public void setGvhd(String gvhd) {
		this.gvhd = gvhd;
	}
	public int getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}
	public int getNam_totnghiep() {
		return nam_totnghiep;
	}
	public void setNam_totnghiep(int nam_totnghiep) {
		this.nam_totnghiep = nam_totnghiep;
	}
	public int getSoluongsinhviendangky() {
		return soluongsinhviendangky;
	}
	public void setSoluongsinhviendangky(int soluongsinhviendangky) {
		this.soluongsinhviendangky = soluongsinhviendangky;
	}
	public String getGvpb() {
		return gvpb;
	}
	public void setGvpb(String gvpb) {
		this.gvpb = gvpb;
	}
	
}
