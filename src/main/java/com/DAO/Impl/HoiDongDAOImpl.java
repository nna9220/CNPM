package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.DBConnection;
import com.DAO.IHoiDongDAO;
import com.Entity.DeTai;
import com.Entity.GiangVien;
import com.Entity.HoiDong;
import com.Entity.Peoples;
import com.Entity.SinhVien;

public class HoiDongDAOImpl extends DBConnection implements IHoiDongDAO {

	@Override
	public void insert1(HoiDong hd) {
		String sql ="INSERT INTO HoiDong(ma_detai,giangvien1,soluong) VALUES(?,?,1)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, hd.getDetai());
			ps.setString(2, hd.getGiangvien1());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public HoiDong getByIdDT(int id) {
		String sql = "SELECT * FROM HoiDong WHERE ma_detai = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HoiDong hoidong = new HoiDong();
				hoidong.setMa_hd(rs.getInt("ma_hd"));
				hoidong.setGiangvien1(rs.getString("giangvien1"));
				hoidong.setGiangvien2(rs.getString("giangvien2"));
				hoidong.setGiangvien3(rs.getString("giangvien3"));
				hoidong.setGiangvien4(rs.getString("giangvien4"));
				hoidong.setGiangvien5(rs.getString("giangvien5"));
				hoidong.setSoluong(rs.getInt("soluong"));
				hoidong.setDetai(rs.getInt("ma_detai"));
				return hoidong;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public GiangVien getOne(String id) {
		String sql = "SELECT * FROM GiangVien WHERE ma_giangvien=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				GiangVien gv = new GiangVien();
				gv.setMa_giangvien(rs.getString("ma_giangvien"));
				gv.setChucvu(rs.getString("chucvu"));
				return gv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//Giangvien2
	@Override
	public void insert2(HoiDong hd) {
		String sql = "UPDATE HoiDOng SET giangvien2=?,soluong=2 WHERE ma_detai=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hd.getGiangvien2());
			ps.setInt(2, hd.getDetai());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void insert3(HoiDong hd) {
		String sql = "UPDATE HoiDOng SET giangvien3=?,soluong=3 WHERE ma_detai=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hd.getGiangvien3());
			ps.setInt(2, hd.getDetai());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void insert4(HoiDong hd) {
		String sql = "UPDATE HoiDOng SET giangvien4=?,soluong=4 WHERE ma_detai=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hd.getGiangvien4());
			ps.setInt(2, hd.getDetai());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void insert5(HoiDong hd) {
		String sql = "UPDATE HoiDOng SET giangvien5=?,soluong=5 WHERE ma_detai=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, hd.getGiangvien5());
			ps.setInt(2, hd.getDetai());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public List<HoiDong> getByGV(String id) {
		List<HoiDong> hoidong = new ArrayList<HoiDong>();
		String sql = "SELECT * FROM HoiDong WHERE giangvien1=? or giangvien2=? or giangvien3=? or giangvien4=? or giangvien5=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, id);
			ps.setString(3, id);
			ps.setString(4, id);
			ps.setString(5, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				HoiDong hd = new HoiDong();
				hd.setMa_hd(rs.getInt("ma_hd"));
				hd.setDetai(rs.getInt("ma_detai"));
				hd.setGiangvien1(rs.getString("giangvien1"));
				hd.setGiangvien2(rs.getString("giangvien2"));
				hd.setGiangvien3(rs.getString("giangvien3"));
				hd.setGiangvien4(rs.getString("giangvien4"));
				hd.setGiangvien5(rs.getString("giangvien5"));
				
				hoidong.add(hd);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hoidong;
	}

}
