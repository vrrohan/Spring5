package com.ron.aop;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.AccountDAO;

public class MainDemoApp {

	// run only setter methods of AccountDAO class and findAccounts() method

	// The annotation we are going to create is one which will be used to log the
	// amount of time it takes a method to execute.

	// Although a relatively simple implementation, it’s worth noting what the two
	// meta-annotations are used for.

	// @Target annotation tells us where our annotation will be applicable. Here we
	// are using ElementType.Method, which means it will only work on methods.
	// If we tried to use the annotation anywhere else, then our code would fail to
	// compile.

	// @Retention just states whether the annotation will be available to the JVM at
	// runtime or not.
	// By default it is not, so Spring AOP would not be able to see the annotation.
	// This is why it’s been reconfigured.

	// create LogExecutionTime @annotation with annotations @Target and @Retention
	// finally , apply @LogExecutionTime annotations on method you want to apply
	// your custom advice
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO accountBean = context.getBean(AccountDAO.class);

		// call business method
		accountBean.setAccountName("Test_AccountName");
		accountBean.setServiceCode("Test_ServiceCode");
		System.out.println(accountBean.getAccountName());
		System.out.println(accountBean.getServiceCode());
		List<Account> customerAccounts = accountBean.findAccounts(false);
		customerAccounts.forEach(x -> System.out.println(x));

		// close the context
		context.close();
	}

}
