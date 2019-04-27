package com.uow.bank.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uow.bank.dao.AccountDAO;
import com.uow.bank.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accDao;

	@Override
	@Transactional
	public boolean saveAccount(Account ac) {
		return accDao.saveAccount(ac);
	}

	@Override
	@Transactional
	public List<Account> getAllAccount() {
		return accDao.getAllAccount();
	}

	@Override
	@Transactional
	public Account getAccountById(int accNum) {
		return accDao.getAccountById(accNum);
	}

	@Override
	@Transactional
	public boolean deleteAccountById(int accNum) {
		return accDao.deleteAccountById(accNum);
	}
	
	@Override
	@Transactional
	public boolean updateAccount(Account ac) {
		return accDao.updateAccount(ac);
	}

}
