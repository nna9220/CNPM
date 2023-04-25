package com.DAO.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Connection.DBConnection;
import com.DAO.IAccountDAO;
import com.Entity.Accounts;

public class AccountDAOImpl extends DBConnection implements IAccountDAO {

	@Override
	public void insert(Accounts acc) {
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
	public void edit(Accounts acc) {
		String sql = "UPDATE Accounts SET password = ? WHERE username =?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, acc.getPassword());
			ps.setString(2, acc.getUsername());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleted(String id) {
		String sql = "DELETE FROM Accounts WHERE username = ?";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Accounts findOne(String id) {
		String sql = "SELECT * FROM Accounts WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Accounts acc = new Accounts();
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setRoleid(rs.getInt("roleid"));
				return acc;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Accounts get(String username) {
		String sql = "SELECT * FROM Accounts WHERE username = ? ";
		try {
			Connection con = super.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Accounts acc = new Accounts();
				acc.setUsername(rs.getString("username"));
				acc.setPassword(rs.getString("password"));
				acc.setRoleid(rs.getInt("roleid"));
				return acc;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
