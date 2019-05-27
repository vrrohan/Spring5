package com.ron.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount(Account accountObject, boolean vipFlag) {
		System.out.println("Add AccountDAO : " + getClass() + " : Adding an account.");
	}

}
