package com.ron.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.AccountDAO;
import com.ron.aop.dao.MembershipDAO;

public class MainDemoApp {

	// @AfterThrowing Advice
	// 1) log the exception
	// 2) perform auditing on exception
	// 3) handle the raised exception in aop advice

	// create an advice that will run after exception is thrown
	// @AfterThrowing annotation with pointcut expression - this advice will run
	// after an exception is thrown
	// inside this method print some statements for logging or checking what
	// exception occurred
	// need to access exception object & log that exception using "throwing" param
	// of Throwable type

	/*
	 * exception will still propagated to main application. we can just see &
	 * process the exception for logging purposes
	 */

	/*
	 * we can make that exception not go back to main application & stop the
	 * application. we can do that using @Around advice type
	 */

	// Process :-
	// 1) In Main App(AfterThrowingMainClass) - add try-catch block for exception
	// handling
	// 2) modify accountdao class to simulate throwing an exception
	// 3) Add @AfterThrowing Advice

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
