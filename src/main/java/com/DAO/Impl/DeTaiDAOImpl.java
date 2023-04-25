package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Connection.DBConnection;
import com.DAO.IDeTaiDAO;
import com.Entity.Accounts;
import com.Entity.DangKyGiangVien;
import com.Entity.DeTai;
import com.Entity.NhomSinhVien;
import com.Entity.Peoples;
import com.Entity.SinhVien;

public class DeTaiDAOImpl extends DBConnection implements IDeTaiDAO {

	@Override
	public void insert(DeTai detai) {
		String sql = "INSERT INTO DeTai(ten_detai,ma_chuyennganh,gvhd,trangthai,nam_totnghiep,soluongsinhviendangky) "
				+ "VALUES (?,?,?,?,?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, detai.getTen_detai());
			ps.setInt(2, detai.getMa_chuyennganh());
			ps.setString(3, detai.getGvhd());
			ps.setInt(4, detai.getTrangthai());
			ps.setInt(5, detai.getNam_totnghiep());
			ps.setInt(6, detai.getSoluongsinhviendangky());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<DeTai> detaiByGV(String id) {
		List<DeTai> dts = new ArrayList<DeTai>();
		String sql = "SELECT * FROM DeTai WHERE gvhd = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai detai = new DeTai();
				detai.setMa_detai(rs.getInt("ma_detai"));
				detai.setTen_detai(rs.getString("ten_detai"));
				detai.setTrangthai(rs.getInt("trangthai"));
				dts.add(detai);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dts;
	}

	@Override
	public void distributionTeacher(DeTai detai) {
		String sql = "UPDATE DeTai SET gvpb = ? WHERE ma_detai =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, detai.getGvpb());
			ps.setInt(2, detai.getMa_detai());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public DeTai get(int id) {
		String sql = "SELECT * FROM DeTai WHERE ma_detai = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				DeTai detai = new DeTai();
				detai.setMa_detai(rs.getInt("ma_detai"));
				detai.setTen_detai(rs.getString("ten_detai"));
				detai.setTrangthai(rs.getInt("trangthai"));
				detai.setGvhd(rs.getString("gvhd"));
				detai.setGvpb(rs.getString("gvpb"));
				detai.setNam_totnghiep(rs.getInt("nam_totnghiep"));
				detai.setMa_chuyennganh(rs.getInt("ma_chuyennganh"));
				detai.setSoluongsinhviendangky(rs.getInt("soluongsinhviendangky"));
				return detai;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DeTai> getAll() {
		List<DeTai> detai = new ArrayList<DeTai>();
		String sql = "SELECT * FROM DeTai";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
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

				detai.add(dt);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detai;
	}

	@Override
	public Peoples getGV(String id) {
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
	public void accessDeTai(DeTai detai) {
		String sql = "UPDATE DeTai SET trangthai = 1 WHERE ma_detai =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, detai.getMa_detai());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void studentRegister(NhomSinhVien nsv) {
		String sql1 = "INSERT INTO NhomSinhVien(truongnhom,ma_detai) VALUES (?,?)";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1, nsv.getTruongnhom());
			ps1.setInt(2, nsv.getMa_detai());
			ps1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
				sv.setStatusdetai(rs.getInt("statusdetai"));
				sv.setDiem_pb(rs.getInt("diem_pb"));
				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertSinhVien(SinhVien sv) {
		String sql = "UPDATE SinhVien SET ma_detai = ?, statusdetai=1 WHERE ma_sinhvien =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sv.getMa_detai());
			ps.setString(2, sv.getMa_sinhvien());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void soluongSV(DeTai dt) {
		String sql = "UPDATE DeTai SET soluongsinhviendangky = 1 WHERE ma_detai =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dt.getMa_detai());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void studentRegister2(NhomSinhVien nsv, SinhVien sv, DeTai dt) {
		String sql1 = "UPDATE NhomSinhVien SET thanhvien=? WHERE ma_detai=?";
		String sql = "UPDATE DeTai SET soluongsinhviendangky = 2 WHERE ma_detai =?";
		String sql2 = "UPDATE SinhVien SET ma_detai = ?,statusdetai=1 WHERE ma_sinhvien =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps1 = con.prepareStatement(sql1);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, dt.getMa_detai());
			ps.executeUpdate();
			ps1.setString(1, nsv.getThanhvien());
			ps1.setInt(2, nsv.getMa_detai());
			ps1.executeUpdate();
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, sv.getMa_detai());
			ps2.setString(2, sv.getMa_sinhvien());
			ps2.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public NhomSinhVien getManhomByDeTai(int ma_detai) {
		String sql = "SELECT * FROM NhomSinhVien WHERE ma_detai = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ma_detai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				NhomSinhVien sv = new NhomSinhVien();
				sv.setMa_nhom(rs.getInt("ma_nhom"));
				sv.setTruongnhom(rs.getString("truongnhom"));
				sv.setThanhvien(rs.getString("thanhvien"));
				sv.setMa_detai(rs.getInt("ma_detai"));
				sv.setNgay_nopdetai(rs.getString("ngay_nopdetai"));
				return sv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DangKyGiangVien> getAllTimeGV() {
		List<DangKyGiangVien> dangkys = new ArrayList<DangKyGiangVien>();
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
				dangkys.add(dk);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dangkys;
	}

	@Override
	public List<DeTai> getAllAccess() {
		List<DeTai> detai = new ArrayList<DeTai>();
		String sql = "SELECT * FROM DeTai";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
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
				if (dt.getTrangthai() == 1) {
					detai.add(dt);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detai;
	}

	@Override
	public void delete(int ma_detai) {
		String sql = "DELETE FROM DeTai WHERE ma_detai = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ma_detai);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<SinhVien> getAllSVAccess(int ma_detai) {
		List<SinhVien> sinhvien = new ArrayList<SinhVien>();
		String sql = "SELECT * FROM SinhVien WHERE ma_detai=?";
		try {
			Connection conn = super.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ma_detai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMa_sinhvien(rs.getString("ma_sinhvien"));
				sv.setMa_detai(rs.getInt("ma_detai"));
				sv.setStatusdetai(rs.getInt("statusdetai"));
				sv.setDiem_pb(rs.getInt("diem_pb"));
				sv.setKhoa(rs.getInt("khoa"));
				if (sv.getMa_detai() == ma_detai) {
					sinhvien.add(sv);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sinhvien;
	}

	@Override
	public void registerTopic(SinhVien sv) {
		String sql = "UPDATE SinhVien SET statusdetai=0,ma_detai=? WHERE ma_sinhvien =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, sv.getMa_detai());
			ps.setString(2, sv.getMa_sinhvien());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
