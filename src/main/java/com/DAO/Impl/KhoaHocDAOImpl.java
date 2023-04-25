package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.DBConnection;
import com.DAO.IKhoaHocDAO;
import com.Entity.DeTai;
import com.Entity.KhoaHoc;

public class KhoaHocDAOImpl extends DBConnection implements IKhoaHocDAO {

	@Override
	public List<KhoaHoc> getAll() {
		List<KhoaHoc> khoahoc = new ArrayList<KhoaHoc>();
		String sql = "SELECT * FROM KhoaHoc";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhoaHoc kh = new KhoaHoc();
				kh.setMa_khoahoc(rs.getInt("ma_khoahoc"));
				kh.setTen_khoahoc(rs.getString("ten_khoahoc"));
				kh.setNam_nhaphoc(rs.getString("nam_nhaphoc"));
				kh.setNam_ketthuc(rs.getString("nam_ketthuc"));
				kh.setNienkhoa(rs.getString("nienkhoa"));
				kh.setCtdt(rs.getString("ctdt"));
				kh.setLopsinhvien(rs.getString("lopsinhvien"));
				khoahoc.add(kh);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return khoahoc;
	}

	@Override
	public KhoaHoc getById(int id) {
		String sql = "SELECT * FROM KhoaHoc WHERE ma_khoahoc = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhoaHoc k = new KhoaHoc();
				k.setMa_khoahoc(rs.getInt("ma_khoahoc"));
				k.setTen_khoahoc(rs.getString("ten_khoahoc"));
				k.setNienkhoa(rs.getString("nienkhoa"));
				k.setNam_nhaphoc(rs.getString("nam_nhaphoc"));
				k.setNam_ketthuc(rs.getString("nam_ketthuc"));
				k.setLopsinhvien(rs.getString("lopsinhvien"));
				k.setCtdt(rs.getString("ctdt"));
				return k;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(KhoaHoc kh) {
		String sql = "INSERT INTO KhoaHoc(ten_khoahoc,nienkhoa,nam_nhaphoc,nam_ketthuc,lopsinhvien,ctdt) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, kh.getTen_khoahoc());
			ps.setString(2, kh.getNienkhoa());
			ps.setString(3, kh.getNam_nhaphoc());
			ps.setString(4, kh.getNam_ketthuc());
			ps.setString(5, kh.getLopsinhvien());
			ps.setString(6, kh.getCtdt());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int ma_khoahoc) {
		String sql = "DELETE FROM KhoaHoc WHERE ma_khoahoc = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ma_khoahoc);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(KhoaHoc kh) {
		String sql = "UPDATE KhoaHoc SET ctdt = ? WHERE ma_khoahoc =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, kh.getCtdt());
			ps.setInt(2,kh.getMa_khoahoc() );
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
