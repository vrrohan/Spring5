package com.ron.aop.dao;

import org.springframework.stereotype.Component;

import com.ron.aop.Account;

@Component
public class AccountDAO {

	public String accountName;
	public String serviceCode;

	public String getAccountName() {
		System.out.println(getClass() + " : get accountName");
		return accountName;
	}

	public void setAccountName(String accountName) {
		System.out.println(getClass() + " : get accountName");
		this.accountName = accountName;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : get serviceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : set serviceCode");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account accountObject, boolean vipFlag) {
		System.out.println("Add AccountDAO : " + getClass() + " : Adding an account.");
	}

}
