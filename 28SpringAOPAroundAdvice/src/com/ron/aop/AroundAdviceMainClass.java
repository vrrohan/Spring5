package com.ron.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.TrafficFortune;

public class AroundAdviceMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		TrafficFortune trafficBean = context.getBean(TrafficFortune.class);
		System.out.println("Calling TrafficFortune from AroundAdviceMainClass");
		System.out.println(trafficBean.getFortune());

		context.close();
	}

}
