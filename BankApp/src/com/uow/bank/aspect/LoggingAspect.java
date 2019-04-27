package com.uow.bank.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut(" execution(* com.uow.bank.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut(" execution(* com.uow.bank.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut(" execution(* com.uow.bank.dao.*.*(..))")
	private void forDAOPackage() {
	}

	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forApplication() {
	}

	@Before("forApplication()")
	private void before(JoinPoint jp) {
		String methodName = jp.getSignature().toShortString();
		logger.info("Information: Inside @Before advice: calling " + methodName + "()");
	}

	@AfterReturning(pointcut = "forApplication()", returning = "result")
	private void afterReturning(JoinPoint jp, Object result) {
		String methodName = jp.getSignature().toShortString();
		logger.info("Information: Inside @AfterReturning advice: calling " + methodName + "()");
		logger.info("Info: Data Return by method " + result);
	}

}
