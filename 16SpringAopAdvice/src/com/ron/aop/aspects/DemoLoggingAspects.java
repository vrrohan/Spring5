package com.ron.aop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspects {
	// collection of related advices class

	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice() {
		System.out.println("Before Advice addAccount() running, class name : " + getClass());
	}

	@After("execution(public void addAccount())")
	public void afterAddAccountAdvice() {
		System.out.println("After Advice addAccount() running, class name : " + getClass());
	}

}
