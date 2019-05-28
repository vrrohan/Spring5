package com.ron.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class UtilityPointcutExpressions {

	@Pointcut("execution(* com.ron.aop.dao.*.*(..))")
	public void forDaoPackage() {
	}

	// Pointcut for getter methods
	@Pointcut("execution(* com.ron.aop.dao.*.get*(..))")
	public void getter() {
	}

	// Pointcut for setter methods
	@Pointcut("execution(* com.ron.aop.dao.*.set*(..))")
	public void setter() {
	}

	// Pointcut to include com.ron.aop.dao package & exclude getter & setter methods
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {
	}

}
