package com.uow.bank.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uow.bank.entity.AccountEntity;
import com.uow.bank.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveAccount(Account account) {
		
		boolean saveFlag=true;
		AccountEntity ae = new AccountEntity();
		ae.setAccNum(account.getAccNum());
		ae.setAccHolderName(account.getAccHolderName());
		ae.setAccBal(account.getAccBal());
		ae.setAccType(account.getAccType());
		ae.setDob(account.getDob());
		ae.setPsCode(account.getPsCode());
		try {
			Session currSess = sessionFactory.getCurrentSession();
			currSess.save(ae);
//			currSess.saveOrUpdate(ae);
		}
		catch(Exception ex){
			ex.printStackTrace();
			saveFlag=false;
		}
		return saveFlag;
	}
	
	@Override
	public boolean updateAccount(Account account) {
		
		boolean saveFlag=true;
		AccountEntity ae = new AccountEntity();
		ae.setAccNum(account.getAccNum());
		ae.setAccHolderName(account.getAccHolderName());
		ae.setAccBal(account.getAccBal());
		ae.setAccType(account.getAccType());
		ae.setDob(account.getDob());
		ae.setPsCode(account.getPsCode());
		try {
			Session currSess = sessionFactory.getCurrentSession();
			currSess.saveOrUpdate(ae);
		}
		catch(Exception ex){
			ex.printStackTrace();
			saveFlag=false;
		}
		return saveFlag;
	}

	@Override
	public List<Account> getAllAccount() {
		
		List<Account> accList = new ArrayList<>();
		try {
			Session sess = sessionFactory.getCurrentSession();
			Query<AccountEntity> query = sess.createQuery("From AccountEntity", AccountEntity.class);
			List<AccountEntity> eList = query.getResultList();
			for (AccountEntity accountEntity : eList) {
				Account acc = new Account();
				acc.setAccNum(accountEntity.getAccNum());
				acc.setAccHolderName(accountEntity.getAccHolderName());
				acc.setAccBal(accountEntity.getAccBal());
				acc.setAccType(accountEntity.getAccType());
				acc.setDob(accountEntity.getDob());
				acc.setPsCode(accountEntity.getPsCode());
				accList.add(acc);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return accList;
	}

	@Override
	public Account getAccountById(int accNum) {
		Account acc = new Account();
		try {
			Session sess = sessionFactory.getCurrentSession();
			AccountEntity accE = (AccountEntity) sess.get(AccountEntity.class, accNum);
			if(accE != null) {
			acc.setAccNum(accE.getAccNum());
			acc.setAccHolderName(accE.getAccHolderName());
			acc.setAccBal(accE.getAccBal());
			acc.setAccType(accE.getAccType());
			acc.setDob(accE.getDob());
			acc.setPsCode(accE.getPsCode());
			} else {
				return null;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	@Override
	public boolean deleteAccountById(int accNum) {
		boolean isDeleted = true;
		try {
			Session sess = sessionFactory.getCurrentSession();
			AccountEntity accE = (AccountEntity) sess.get(AccountEntity.class, accNum);
			sess.delete(accE);
			
		}catch(Exception e) {
			e.printStackTrace();
			isDeleted = false;
		}
		return isDeleted;
	}
	

}
