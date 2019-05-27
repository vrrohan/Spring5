package com.ron.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspects {
	// collection of related advices class

	@Pointcut("execution(* add*(..))")
	private void forDaoPackage() {
	}

	// @Before("execution(public void addAccount())")
	// Calling fully qualified class name, call addAccount() of only MembershipDAO
	// class
	// @Before("execution(* add*(com.ron.aop.dao.Account))")
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("Before Advice addAccount() running, class name : " + getClass());
	}

	// now this works only for accountdao class, not for memberdao class

	@Before("forDaoPackage()")
	public void performingAuthentication() {
		System.out.println("performingAuthentication(), class name : " + getClass());
	}

}
