package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.DBConnection;
import com.DAO.ISinhVienDAO;
import com.Entity.Accounts;
import com.Entity.KhoaHoc;
import com.Entity.Peoples;
import com.Entity.SinhVien;

public class SinhVienDAOImpl extends DBConnection implements ISinhVienDAO {

	/// DAOImpl
	@Override
	public void edit(Peoples sv) {
		String sql = "UPDATE Peoples SET hoten=? WHERE id=?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sv.getHoten());
//			ps.setString(2, sv.getNgaysinh());
//			ps.setInt(3, sv.getGioitinh());
//			ps.setString(4, sv.getDiachi());
//			ps.setString(5, sv.getSdt());
//			ps.setString(6, sv.getEmail());
			ps.setString(2, sv.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String id, String email) {
		String sql0 = "DELETE FROM Accounts WHERE username = ?";
		String sql = "DELETE FROM SinhVien WHERE ma_sinhvien = ?";
		String sql1 = "DELETE FROM Peoples WHERE id = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			PreparedStatement ps1 = con.prepareStatement(sql1);
			PreparedStatement ps0 = con.prepareStatement(sql0);
			ps0.setString(1, email);
			ps.setString(1, id);
			ps1.setString(1, id);
			ps0.executeUpdate();
			ps.executeUpdate();
			ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Peoples pp, SinhVien sv) {
		String sql = "INSERT INTO Peoples(id,hoten,ngaysinh,gioitinh,diachi,sdt,email,ma_chuyennganh,roleid) VALUES (?,?,?,?,?,?,?,?,4)";
		String sql1 = "INSERT INTO SinhVien(ma_sinhvien,khoa) VALUES (?,?)";
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
			ps.executeUpdate();
			ps1.setString(1, sv.getMa_sinhvien());
			ps1.setInt(2, sv.getKhoa());
			ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Peoples> getAll() {
		List<Peoples> svs = new ArrayList<Peoples>();
		String sql = "SELECT * FROM Peoples";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
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
				if (pp.getRoleid() == 4) {
					svs.add(pp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return svs;
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
	public SinhVien getSV(String id) {
		String sql = "SELECT * FROM SinhVien WHERE ma_sinhvien = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMa_sinhvien(rs.getString("ma_sinhvien"));
				sv.setKhoa(rs.getInt("khoa"));
				sv.setMa_detai(rs.getInt("ma_detai"));
				sv.setDiem_pb(rs.getInt("diem_pb"));
				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Accounts getAcc(String email) {
		String sql = "SELECT * FROM Accounts WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Accounts acc = new Accounts();
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				return acc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addAcc(Accounts acc) {
		String sql = "INSERT INTO Accounts(username,password,roleid) VALUES (?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, acc.getUsername());
			ps.setString(2, acc.getPassword());
			ps.setInt(3, acc.getRoleid());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public KhoaHoc getK(int khoa) {
		String sql = "SELECT * FROM KhoaHoc WHERE ma_khoahoc = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, khoa);
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
	public List<Peoples> search(String key) {
		List<Peoples> svs = new ArrayList<Peoples>();
		String sql = "SELECT * FROM Peoples WHERE hoten like ? or id like ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
//			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps.setString(1, "%" + key + "%");
			ps.setString(2, "%" + key + "%");
			ResultSet rs = ps.executeQuery();
//			ResultSet rs1 = ps.executeQuery();
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
				
//				pp.setId(rs1.getString("id"));
//				pp.setHoten(rs1.getString("hoten"));
//				pp.setNgaysinh(rs1.getString("ngaysinh"));
//				pp.setGioitinh(rs1.getInt("gioitinh"));
//				pp.setDiachi(rs1.getString("diachi"));
//				pp.setSdt(rs1.getString("sdt"));
//				pp.setEmail(rs1.getString("email"));
//				pp.setMa_chuyennganh(rs1.getInt("ma_chuyennganh"));
//				pp.setRoleid(rs.getInt("roleid"));
				if (pp.getRoleid() == 4) {
					svs.add(pp);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return svs;
	}

	@Override
	public Peoples getByEmail(String email) {
		String sql = "SELECT * FROM Peoples WHERE email = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
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

}
