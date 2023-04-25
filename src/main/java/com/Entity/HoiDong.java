package com.Entity;

public class HoiDong {
	private int ma_hd;
	private String giangvien1;
	private String giangvien2;
	private String giangvien3;
	private String giangvien4;
	private String giangvien5;
	private int detai;
	private int soluong;
	public HoiDong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getGiangvien1() {
		return giangvien1;
	}

	public void setGiangvien1(String giangvien1) {
		this.giangvien1 = giangvien1;
	}

	public String getGiangvien2() {
		return giangvien2;
	}

	public void setGiangvien2(String giangvien2) {
		this.giangvien2 = giangvien2;
	}

	public String getGiangvien3() {
		return giangvien3;
	}

	public void setGiangvien3(String giangvien3) {
		this.giangvien3 = giangvien3;
	}

	public String getGiangvien4() {
		return giangvien4;
	}

	public void setGiangvien4(String giangvien4) {
		this.giangvien4 = giangvien4;
	}

	public String getGiangvien5() {
		return giangvien5;
	}

	public void setGiangvien5(String giangvien5) {
		this.giangvien5 = giangvien5;
	}

	public HoiDong(int ma_hd, String giangvien1, String giangvien2, String giangvien3, String giangvien4,
			String giangvien5, int detai, int soluong) {
		super();
		this.ma_hd = ma_hd;
		this.giangvien1 = giangvien1;
		this.giangvien2 = giangvien2;
		this.giangvien3 = giangvien3;
		this.giangvien4 = giangvien4;
		this.giangvien5 = giangvien5;
		this.detai = detai;
		this.soluong = soluong;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getMa_hd() {
		return ma_hd;
	}
	public void setMa_hd(int ma_hd) {
		this.ma_hd = ma_hd;
	}
	public int getDetai() {
		return detai;
	}
	public void setDetai(int detai) {
		this.detai = detai;
	}
}
