package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.DBConnection;
import com.DAO.IGiangVienDAO;
import com.Entity.GiangVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;

public class GiangVienDAOImpl extends DBConnection implements IGiangVienDAO {

	@Override
	public void insert(Peoples pp, GiangVien gv) {
		String sql = "INSERT INTO Peoples(id,hoten,ngaysinh,gioitinh,diachi,sdt,email,ma_chuyennganh,roleid) VALUES (?,?,?,?,?,?,?,?,?)";
		String sql1 = "INSERT INTO GiangVien(ma_giangvien,chucvu) VALUES (?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps.setString(1, pp.getId());
			ps.setString(2, pp.getHoten());
			ps.setString(3, pp.getNgaysinh());
			ps.setInt(4, pp.getGioitinh());
			ps.setString(5, pp.getDiachi());
			ps.setString(6, pp.getSdt());
			ps.setString(7, pp.getEmail());
			ps.setInt(8, pp.getMa_chuyennganh());
			ps.setInt(9, pp.getRoleid());
			ps.executeUpdate();
			ps1.setString(1, gv.getMa_giangvien());
			ps1.setString(2, gv.getChucvu());
			ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void edit(Peoples gv) {
		String sql = "UPDATE Peoples SET hoten=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, gv.getHoten());
//			ps.setString(2, sv.getNgaysinh());
//			ps.setInt(3, sv.getGioitinh());
//			ps.setString(4, sv.getDiachi());
//			ps.setString(5, sv.getSdt());
//			ps.setString(6, sv.getEmail());
			ps.setString(2, gv.getId());
			ps.executeUpdate(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id) {
		String sql = "DELETE FROM GiangVien WHERE ma_giangvien = ?";
		String sql1 = "DELETE FROM Peoples WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps1 = con.prepareStatement(sql1);

			ps.setString(1, id);
			ps1.setString(1, id);
			;
			ps.executeUpdate();
			ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Peoples> getAll() {
		List<Peoples> gvs = new ArrayList<Peoples>();
		String sql = "SELECT * FROM Peoples";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Peoples gv = new Peoples();

				gv.setId(rs.getString("id"));
				gv.setHoten(rs.getString("hoten"));
				gv.setNgaysinh(rs.getString("ngaysinh"));
				gv.setGioitinh(rs.getInt("gioitinh"));
				gv.setDiachi(rs.getString("diachi"));
				gv.setSdt(rs.getString("sdt"));
				gv.setEmail(rs.getString("email"));
				gv.setRoleid(rs.getInt("roleid"));
				gv.setMa_chuyennganh(rs.getInt("ma_chuyennganh"));
				if (gv.getRoleid() == 2 || gv.getRoleid() == 3) {
					gvs.add(gv);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gvs;
	}

	@Override
	public Peoples get(String id) {
		String sql = "SELECT * FROM Peoples WHERE id = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Peoples pp = new Peoples();
				pp.setId(rs.getString("id"));
				pp.setHoten(rs.getString("hoten"));
				pp.setNgaysinh(rs.getString("ngaysinh"));
				pp.setGioitinh(rs.getInt("gioitinh"));
				pp.setDiachi(rs.getString("diachi"));
				pp.setSdt(rs.getString("sdt"));
				pp.setEmail(rs.getString("email"));
				pp.setMa_chuyennganh(rs.getInt("ma_chuyennganh"));
				pp.setRoleid(rs.getInt("roleid"));
				return pp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Peoples> search(String key) {
		List<Peoples> svs = new ArrayList<Peoples>();
		String sql = "SELECT * FROM Peoples WHERE hoten like ? or id like ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + key + "%");
			ps.setString(2, "%" + key + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Peoples pp = new Peoples();
				pp.setId(rs.getString("id"));
				pp.setHoten(rs.getString("hoten"));
				pp.setNgaysinh(rs.getString("ngaysinh"));
				pp.setGioitinh(rs.getInt("gioitinh"));
				pp.setDiachi(rs.getString("diachi"));
				pp.setSdt(rs.getString("sdt"));
				pp.setEmail(rs.getString("email"));
				pp.setMa_chuyennganh(rs.getInt("ma_chuyennganh"));
				pp.setRoleid(rs.getInt("roleid"));

				if (pp.getRoleid() == 2 || pp.getRoleid() == 3 ) {
					svs.add(pp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return svs;
	}

	@Override
	public GiangVien getGV(String id) {
		String sql = "SELECT * FROM GiangVien WHERE ma_giangvien = ? ";
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
}
