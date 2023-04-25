package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Connection.DBConnection;
import com.Entity.Accounts;
import com.Entity.DeTai;
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;

public class AccountDAO extends DBConnection {
	private Connection conn;
	private PreparedStatement stm;
	private ResultSet rs;

	private void closeConnection() throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (stm != null) {
			stm.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public Accounts checkLogin(String username, String password) throws SQLException, Exception {
		try {
			Connection conn = super.getConnection();
			if (conn != null) {
				String sql = "SELECT username , password , roleid"
						+ " FROM Accounts WHERE username = ? AND password = ?";
				PreparedStatement stm = conn.prepareStatement(sql);
				stm.setString(1, username);
				stm.setString(2, password);
				ResultSet rs = stm.executeQuery();
				if (rs.next()) {
					Accounts result = new Accounts(rs.getString("username"), rs.getString("password"),
							rs.getInt("roleid"));
					return result;
				} else {
					System.out.println("\n\ndatabase user null\n");
				}
			} else {
				System.out.println("\n\nconnection null\n");
			}
		} catch (Exception e) {
		} finally {
			closeConnection();
		}
		return null;
	}

	public Peoples getEmail(String email) {
		String sql = "SELECT * FROM Peoples WHERE email=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Peoples sv = new Peoples();
				sv.setId(rs.getString("id"));
				sv.setHoten(rs.getString("hoten"));
				sv.setSdt(rs.getString("sdt"));
				sv.setDiachi(rs.getString("diachi"));
				sv.setNgaysinh(rs.getString("ngaysinh"));
				sv.setGioitinh(rs.getInt("gioitinh"));
				sv.setEmail(rs.getString("email"));
				sv.setRoleid(rs.getInt("roleid"));
				sv.setMa_chuyennganh(rs.getInt("ma_chuyennganh"));
				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<Peoples> getAll() {
		List<Peoples> svs = new ArrayList<Peoples>();
		String sql = "SELECT * FROM Peoples";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			Peoples sv = new Peoples();
			
			sv.setId(rs.getString("id"));
			sv.setHoten(rs.getString("hoten"));
			sv.setNgaysinh(rs.getString("ngaysinh"));
			sv.setGioitinh(rs.getInt("gioitinh"));
			sv.setEmail(rs.getString("email"));
			sv.setRoleid(rs.getInt("roleid"));
			sv.setMa_chuyennganh(rs.getInt("ma_chuyennganh"));
			if(sv.getRoleid() == 2 || sv.getRoleid() == 3 )
			{
			svs.add(sv);
			}
			
			}} catch (Exception e) {
			e.printStackTrace();}
		return svs;
	}
	public List<Accounts> getAllAccount() {
		List<Accounts> accs = new ArrayList<Accounts>();
		String sql = "SELECT * FROM Accounts";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
			Accounts acc = new Accounts();
			acc.setUsername(rs.getString("username"));
			acc.setPassword(rs.getString("password"));
			acc.setRoleid(rs.getInt("roleid"));
			accs.add(acc);
			}} catch (Exception e) {
			e.printStackTrace();}
		return accs;
	}
	
	public SinhVien getSV(String id) {
		String sql = "SELECT * FROM SinhVien WHERE ma_sinhvien=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMa_sinhvien(rs.getString("ma_sinhvien"));
				sv.setStatusdetai(rs.getInt("statusdetai"));
				sv.setMa_detai(rs.getInt("ma_detai"));
				sv.setKhoa(rs.getInt("khoa"));
				sv.setDiem_pb(rs.getInt("diem_pb"));

				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public DeTai getDeTaiByMaDT(int id) {
		String sql = "SELECT * FROM DeTai WHERE ma_detai=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai dt = new DeTai();
				dt.setMa_detai(rs.getInt("ma_detai"));
				dt.setTen_detai(rs.getString("ten_detai"));
				dt.setGvhd(rs.getString("gvhd"));
				dt.setTrangthai(rs.getInt("trangthai"));
				dt.setMa_chuyennganh(rs.getInt("ma_chuyennganh"));
				dt.setGvpb(rs.getString("gvpb"));
				dt.setNam_totnghiep(rs.getInt("nam_totnghiep"));
				dt.setSoluongsinhviendangky(rs.getInt("soluongsinhviendangky")); 
				return dt;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public NhomSinhVien getNSVByMaDT(int id) {
		String sql = "SELECT * FROM NhomSinhVien WHERE ma_detai=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhomSinhVien nsv = new NhomSinhVien();
				nsv.setMa_nhom(rs.getInt("ma_nhom"));
				nsv.setMa_detai(rs.getInt("ma_detai"));
				nsv.setTruongnhom(rs.getString("truongnhom"));
				nsv.setThanhvien(rs.getString("thanhvien"));
				nsv.setNgay_nopdetai(rs.getString("ngay_nopdetai"));
				return nsv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Peoples getSVById(String id) {
		String sql = "SELECT * FROM Peoples WHERE id=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Peoples sv = new Peoples();
				sv.setId(rs.getString("id"));
				sv.setSdt(rs.getString("sdt"));
				sv.setDiachi(rs.getString("diachi"));
				sv.setHoten(rs.getString("hoten"));
				sv.setNgaysinh(rs.getString("ngaysinh"));
				sv.setGioitinh(rs.getInt("gioitinh"));
				sv.setEmail(rs.getString("email"));
				sv.setRoleid(rs.getInt("roleid"));
				sv.setMa_chuyennganh(rs.getInt("ma_chuyennganh"));
				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
