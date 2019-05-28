package com.ron.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.AccountDAO;
import com.ron.aop.dao.MembershipDAO;

public class MainDemoApp {

	// @After Advice - runs after method is completed, regardless method runs
	// successfully or failure(exception) (like a finally block)

	// if both @After and @AfterThrowing is matching on same pointcut, @After always
	// runs before @AfterThrowing advice

	// use cases -
	// 1) log the exception or perform auditing
	// 2) run the code regardless of method outcome, cleaning of some resources
	// 3) encapsulate this functionality in AOP Aspect & reuse in different places

	// @After - doesn't have access to exception, if you need to handle or log
	// exception use - @AfterThrowing

	// @After should be able to run in case of success or failure, logging or
	// auditing code is easiest here

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
