package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.DBConnection;
import com.DAO.IDotDangKyGiangVienDAO;
import com.Entity.DangKyGiangVien;
import com.Entity.DeTai;
import com.Entity.Peoples;

public class DotDangKyGiangVienDAOImpl extends DBConnection implements IDotDangKyGiangVienDAO {

	@Override
	public void insert(DangKyGiangVien dk) {
		String sql = "INSERT INTO DangKyGiangVien(ngaybatdau,ngayketthuc) VALUES (?,?)";
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
	public void edit(DangKyGiangVien dk) {
		String sql = "UPDATE DangKyGiangVien SET ngaybatdau=?,ngayketthuc=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dk.getNgaybatdau());
			ps.setString(2, dk.getNgayketthuc());
			ps.setInt(3, dk.getId());
			ps.executeUpdate(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<DangKyGiangVien> getAll() {
		List<DangKyGiangVien> dks = new ArrayList<DangKyGiangVien>();
		String sql = "SELECT * FROM DangKyGiangVien";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DangKyGiangVien dk = new DangKyGiangVien();
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
	public DangKyGiangVien getById(int id) {
		String sql = "SELECT * FROM DangKyGiangVien WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DangKyGiangVien dk =new DangKyGiangVien();
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
