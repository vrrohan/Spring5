package com.ron.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspects {
	// collection of related advices class

	@Pointcut("execution(* com.ron.aop.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// Pointcut for getter methods
	@Pointcut("execution(* com.ron.aop.dao.*.get*(..))")
	private void getter() {
	}

	// Pointcut for setter methods
	@Pointcut("execution(* com.ron.aop.dao.*.set*(..))")
	private void setter() {
	}

	// Pointcut to include com.ron.aop.dao package & exclude getter & setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {
	}

	// @Before("execution(public void addAccount())")
	// Calling fully qualified class name, call addAccount() of only MembershipDAO
	// class
	// @Before("execution(* add*(com.ron.aop.dao.Account))")
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("Before Advice addAccount() running, class name : " + getClass());
	}

	// now this works only for accountdao class, not for memberdao class

	@Before("forDaoPackageNoGetterSetter()")
	public void performingAuthentication() {
		System.out.println("performingAuthentication(), class name : " + getClass());
	}

}
