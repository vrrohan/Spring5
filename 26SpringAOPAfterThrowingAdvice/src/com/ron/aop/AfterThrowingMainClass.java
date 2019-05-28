package com.ron.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.AccountDAO;

public class AfterThrowingMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO accountBean = context.getBean(AccountDAO.class);
		List<Account> allAccounts = null;
		try {
			// Add boolean flag to simulate(generate) exceptions
			boolean trip = true;
			allAccounts = accountBean.findAccounts(trip);
		} catch (Exception e) {
			System.out.println("Main program catch exception block " + e);
		}

		System.out.println();
		allAccounts.forEach(x -> System.out.println(x));

		// close the context
		context.close();
	}

}
