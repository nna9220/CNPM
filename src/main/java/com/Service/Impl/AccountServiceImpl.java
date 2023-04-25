package com.Service.Impl;

import com.DAO.IAccountDAO;
import com.DAO.Impl.AccountDAOImpl;
import com.Entity.Accounts;
import com.Service.IAccountService;

public class AccountServiceImpl implements IAccountService {
	IAccountDAO accDAO = new AccountDAOImpl();
	
	@Override
	public Accounts get(String username) {
		// TODO Auto-generated method stub
		return accDAO.get(username);
	}
	
	@Override
	public void insert(Accounts acc) {
		accDAO.insert(acc);
	}

	@Override
	public void edit(Accounts acc) {
		
		Accounts old = accDAO.get(acc.getUsername());
		old.setPassword(acc.getPassword());
		accDAO.edit(old);
	}

	@Override
	public void deleted(String id) {
		accDAO.deleted(id);
	}

	@Override
	public Accounts findOne(String id) {
		// TODO Auto-generated method stub
		return accDAO.findOne(id);
	}

	

}
