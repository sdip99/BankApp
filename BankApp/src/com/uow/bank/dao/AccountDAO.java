package com.uow.bank.dao;

import java.util.List;

import com.uow.bank.entity.AccountEntity;
import com.uow.bank.model.Account;

public interface AccountDAO {

	public boolean saveAccount(Account account);
	public List<Account> getAllAccount();
	public Account getAccountById(int accNum);
	public boolean deleteAccountById(int accNum);
	boolean updateAccount(Account account);
}
