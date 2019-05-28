package com.ron.aop.aspects;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CustomLogExecutionAspect {

	private static Logger logger = Logger.getLogger(CustomLogExecutionAspect.class.getName());

	@Around("@annotation(com.ron.aop.aspects.LogExecutionTime)")
	public Object LogExecutionTime(ProceedingJoinPoint proceedJoinPoint) throws Throwable {
		logger.info("===>@Around Aspect. Method Signature : " + proceedJoinPoint.getSignature().toString());
		long startTimeStamp = System.currentTimeMillis();
		Object result = proceedJoinPoint.proceed();
		long endTimeStamp = System.currentTimeMillis();
		logger.info("===>Total execution time : " + (endTimeStamp - startTimeStamp) / 1000.0 + " seconds.");
		return result;
	}
}
