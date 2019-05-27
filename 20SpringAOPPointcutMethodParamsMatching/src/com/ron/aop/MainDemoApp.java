package com.ron.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ron.aop.dao.Account;
import com.ron.aop.dao.AccountDAO;
import com.ron.aop.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from spring container
		AccountDAO accountBean = context.getBean(AccountDAO.class);
		MembershipDAO memberBean = context.getBean(MembershipDAO.class);

		// call business method
		accountBean.addAccount(new Account(), true);
		System.out.println("\nMembership Add Account\n");
		memberBean.addMemberAccount(10, false, new int[] { 11, 22, 33 });

		// close the context
		context.close();
	}

}
