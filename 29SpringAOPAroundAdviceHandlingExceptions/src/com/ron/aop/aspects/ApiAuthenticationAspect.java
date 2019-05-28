package com.ron.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class ApiAuthenticationAspect {

	@Before("com.ron.aop.aspects.UtilityPointcutExpressions.forDaoPackageNoGetterSetter()")
	public void performingApiAuthentication() {
		System.out.println("performingAuthentication(), class name : " + getClass());
	}

}
