package com.ron.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLoggingAspect {

	@Before("com.ron.aop.aspects.UtilityPointcutExpressions.forDaoPackageNoGetterSetter()")
	public void performingCloudLogging() {
		System.out.println("performingCloudLogging(), class name : " + getClass());
	}

}
