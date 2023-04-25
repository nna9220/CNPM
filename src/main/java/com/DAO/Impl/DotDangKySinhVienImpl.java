package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.DBConnection;
import com.DAO.IDotDangKySinhVienDAO;
import com.Entity.DangKyGiangVien;
import com.Entity.DangKySinhVien;

public class DotDangKySinhVienImpl extends DBConnection implements IDotDangKySinhVienDAO {

	@Override
	public void insert(DangKySinhVien dk) {
		String sql = "INSERT INTO DangKySinhVien(ngaybatdau,ngayketthuc) VALUES (?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dk.getNgaybatdau());
			ps.setString(2, dk.getNgayketthuc());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void edit(DangKySinhVien dk) {
		String sql = "UPDATE DangKySinhVien SET ngaybatdau=?,ngayketthuc=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dk.getNgaybatdau());
			ps.setString(2, dk.getNgayketthuc());
			ps.setInt(3, dk.getId());
			ps.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<DangKySinhVien> getAll() {
		List<DangKySinhVien> dks = new ArrayList<DangKySinhVien>();
		String sql = "SELECT * FROM DangKySinhVien";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DangKySinhVien dk = new DangKySinhVien();
				dk.setId(rs.getInt("id"));
				dk.setNgaybatdau(rs.getString("ngaybatdau"));
				dk.setNgayketthuc(rs.getString("ngayketthuc"));
				dks.add(dk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dks;
	}

	@Override
	public DangKySinhVien getById(int id) {
		String sql = "SELECT * FROM DangKySinhVien WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DangKySinhVien dk =new DangKySinhVien();
				dk.setId(rs.getInt("id"));
				dk.setNgaybatdau(rs.getString("ngaybatdau"));
				dk.setNgayketthuc(rs.getString("ngayketthuc"));
				return dk;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
