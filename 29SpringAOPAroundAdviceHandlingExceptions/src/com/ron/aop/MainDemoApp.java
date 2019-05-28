package com.ron.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.AccountDAO;
import com.ron.aop.dao.MembershipDAO;

public class MainDemoApp {

	// @Around - runs before & after method execution

	// @Around - like a combination of @Before & @After, but gives you more fine
	// grained control over the process

	// Uses -
	// 1) For logging, security, auditing & handling exception & don't propagate to
	// main app
	// 2) Pre-process and post-process the data
	// 3) check how long does it take for a section of code to run
	// 4) swallow, handle or stop the exception

	// when using @Around advice, you get reference to ProceedingJoinPoint. Just a
	// handle to target method(execute it).

	// create an advice for instrumentation/profiling code - how long a section of
	// code takes to run

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO accountBean = context.getBean(AccountDAO.class);
		MembershipDAO memberBean = context.getBean(MembershipDAO.class);

		// call business method
		Account myAccount = new Account();
		myAccount.setId(111);
		myAccount.setName("mark");
		accountBean.addAccount(myAccount, true);
		accountBean.setAccountName("Test_AccountName");
		accountBean.setServiceCode("Test_ServiceCode");
		System.out.println(accountBean.getAccountName());
		System.out.println(accountBean.getServiceCode());
		System.out.println("\nMembership Add Account\n");

		memberBean.addMemberAccount(10, false, new int[] { 11, 22, 33 });
		memberBean.getAllAccountsNumbers();

		// close the context
		context.close();
	}

}
