package com.ron.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		// get bean from spring container
		AccountDAO accountBean = context.getBean(AccountDAO.class);
		// call business method
		accountBean.addAccount();
		System.out.println("\ncalling bean method again\n");
		accountBean.addAccount();
		// close the context
		context.close();
	}

}
