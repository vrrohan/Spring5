package com.ron.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.AccountDAO;
import com.ron.aop.dao.MembershipDAO;

public class MainDemoApp {

	// 1) Add constructor to Account class
	// 2) Add findAccounts() to AccountDAO class
	// 3) call findAccounts() in another main class AfterReturnMainClass
	// 4) Add @AfterReturning advice to AddAccountDeviceAspect

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
