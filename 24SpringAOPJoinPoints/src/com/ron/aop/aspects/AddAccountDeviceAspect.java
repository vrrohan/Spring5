package com.ron.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ron.aop.Account;

@Aspect
@Component
@Order(3)
public class AddAccountDeviceAspect {

	@Before("com.ron.aop.aspects.UtilityPointcutExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoints) {
		System.out.println("performing beforeAddAccountDevice(), class name : " + getClass());

		// display method signature
		MethodSignature methSignature = (MethodSignature) joinPoints.getSignature();
		System.out.println("Method Signature : " + methSignature);

		// display method arguments
		Object[] methArgs = joinPoints.getArgs();
		System.out.print("Method Arguments : ");
		for (Object args : methArgs) {
			if (args instanceof Account) {
				// access account class variables
				Account acc = (Account) args;
				System.out.println("Account name : " + acc.getName());
				System.out.println("Account id : " + acc.getId());
			} else {
				System.out.println(args);
			}
		}
	}

}
