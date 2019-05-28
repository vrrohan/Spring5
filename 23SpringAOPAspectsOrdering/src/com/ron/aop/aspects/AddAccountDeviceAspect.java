package com.ron.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class AddAccountDeviceAspect {

	@Before("com.ron.aop.aspects.UtilityPointcutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("performing beforeAddAccountDevice(), class name : " + getClass());
	}

}
