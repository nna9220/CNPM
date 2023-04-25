package com.Entity;

public class Accounts {
	private String username, password;
    private int roleid;
	public Accounts() {
		super();
	}
	public Accounts(String username, String password, int roleid) {
		super();
		this.username = username;
		this.password = password;
		this.roleid = roleid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
}
