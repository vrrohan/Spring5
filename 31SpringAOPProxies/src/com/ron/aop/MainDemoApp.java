package com.ron.aop;

import java.util.List;

import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import com.ron.aop.aspects.CustomLogExecutionAspect;
import com.ron.aop.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// read spring config java class
		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(DemoConfig.class);

		// create object to be proxied
		AccountDAO accountDaoObject = new AccountDAO();

		// create proxy factory
		AspectJProxyFactory proxyFactory = new AspectJProxyFactory(accountDaoObject);

		// add aspect class to proxy
		proxyFactory.addAspect(CustomLogExecutionAspect.class);

		// get proxy object
		AccountDAO accountBean = proxyFactory.getProxy();

		// call business method
		accountBean.setAccountName("Test_AccountName");
		accountBean.setServiceCode("Test_ServiceCode");
		System.out.println(accountBean.getAccountName());
		System.out.println(accountBean.getServiceCode());
		List<Account> customerAccounts = accountBean.findAccounts(false);
		customerAccounts.forEach(x -> System.out.println(x));

	}

}
