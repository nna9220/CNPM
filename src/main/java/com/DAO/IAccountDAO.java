package com.DAO;


import com.Entity.Accounts;


public interface IAccountDAO {
	void insert(Accounts acc);
	void edit(Accounts acc);
	void deleted(String id);
	Accounts get(String username);
	Accounts findOne(String id);
}
