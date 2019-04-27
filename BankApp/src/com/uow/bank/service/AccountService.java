package com.uow.bank.service;

import java.util.List;

import javax.validation.Valid;

import com.uow.bank.model.Account;

public interface AccountService {

	public boolean saveAccount(Account ac);
	public List<Account> getAllAccount();
	public Account getAccountById(int accNum);
	public boolean deleteAccountById(int accNum);
	public boolean updateAccount(@Valid Account acc);
	
}
