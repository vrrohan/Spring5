package com.ron.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println("Add AccountDAO : " + getClass() + " : Adding an account.");
	}
}
