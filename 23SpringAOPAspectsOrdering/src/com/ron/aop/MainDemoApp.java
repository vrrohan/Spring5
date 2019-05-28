package com.ron.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.AccountDAO;
import com.ron.aop.dao.MembershipDAO;

public class MainDemoApp {

	/*
	 * How to manage aspect ordering ? accord. to spec. this order is undefined.
	 * Spring just picks randomly & execute it. To control aspect ordering & how
	 * advices are applied - 1) Refactor code : places advices in separate aspects
	 * 2) Add @Order annotations to aspects
	 * 
	 * @Order(1) - lower number have higher precedence, -ive numbers also allowed
	 * 
	 * Right now aspects execution in order of their definition lets perform aspect
	 * 1st authentication, 2nd cloudlogging & 3rd addAccountDevice
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO accountBean = context.getBean(AccountDAO.class);
		MembershipDAO memberBean = context.getBean(MembershipDAO.class);

		// call business method
		accountBean.addAccount(new Account(), true);
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
