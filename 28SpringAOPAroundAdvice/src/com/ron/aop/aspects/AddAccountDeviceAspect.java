package com.ron.aop.aspects;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	@AfterReturning(pointcut = "execution(* com.ron.aop.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturnFindAccountsAdvice(JoinPoint joinPoints, List<Account> result) {
		// display method signature
		System.out.println("\nAfter Return Method : " + joinPoints.getSignature().toString());
		System.out.println("After Return result : " + result);

		// modify returning list data
		if (result.size() > 0) {
			result.add(new Account("NewAccountName", 1001));
		}
	}

	@AfterThrowing(pointcut = "execution(* com.ron.aop.dao.AccountDAO.findAccounts(..))", throwing = "excep")
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoints, Throwable excep) {
		System.out.println("@AfterThrowing Advice method signature : " + joinPoints.getSignature().toString());
		System.out.println("Exception is : " + excep);
	}

	@After("execution(* com.ron.aop.dao.AccountDAO.findAccounts(..))")
	public void afterAdviceFindAccountsAdvice(JoinPoint joinPoints) {
		System.out.println("@After Advice method signature : " + joinPoints.getSignature().toString());
	}

	@Around("execution(* com.ron.aop.dao.TrafficFortune.getFortune(..))")
	public Object aroundAdviceGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		// print method signature
		System.out.println("@Around method signature : " + proceedingJoinPoint.getSignature().toString());

		// begin code timestamp
		long startPoint = System.currentTimeMillis();

		// execute the method using proceed()
		Object result = proceedingJoinPoint.proceed();

		// end code timestamp
		long endPoint = System.currentTimeMillis();

		System.out.println("code duration timestamp : " + (endPoint - startPoint) / 1000.0 + " seconds.");
		return result;
	}
}
