package com.ron.aop;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.TrafficFortune;

public class AroundAdviceMainClass {

	// @Around - you can handle the exception or re-throw the same exception

	private static Logger logger = Logger.getLogger(AroundAdviceMainClass.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		TrafficFortune trafficBean = context.getBean(TrafficFortune.class);
		logger.info("Calling TrafficFortune from AroundAdviceMainClass");
		logger.info(trafficBean.getFortune(true));

		context.close();
	}

}
