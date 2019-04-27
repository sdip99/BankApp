package com.uow.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.uow.bank.dao.AccountDAO;
import com.uow.bank.model.Account;

@Aspect
@Component
public class AccountAspect {

		@Before("execution(* com.uow.bank.dao.AccountDAOImpl.saveAccount(..))")
		private void validateAccount(JoinPoint jp) {
			System.out.println("Validate Account is being processed...");
			Object []args = jp.getArgs();
			Account acc = (Account) args[0];
			int accNum = acc.getAccNum();
			AccountDAO accDao = (AccountDAO)jp.getTarget();
			if(accDao.getAccountById(accNum)!=null) {
				throw new RuntimeException("Account with Account number " + accNum + " is alredy present.");
			}
		}
}
