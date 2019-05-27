package com.ron.aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspects {
	// collection of related advices class

	// @Before("execution(public void addAccount())")
	// Calling fully qualified class name, call addAccount() of only MembershipDAO
	// class
	@Before("execution(public void add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("Before Advice addAccount() running, class name : " + getClass());
	}

	// now this works only for accountdao class, not for memberdao class
	@After("execution(public void addAccount())")
	public void afterAddAccountAdvice() {
		System.out.println("After Advice addAccount() running, class name : " + getClass());
	}

}
