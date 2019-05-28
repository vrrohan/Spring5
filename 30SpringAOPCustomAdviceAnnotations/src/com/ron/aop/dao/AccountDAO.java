package com.ron.aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ron.aop.Account;
import com.ron.aop.aspects.LogExecutionTime;

@Component
public class AccountDAO {

	public String accountName;
	public String serviceCode;

	@LogExecutionTime
	public String getAccountName() {
		System.out.println(getClass() + " : get accountName");
		return accountName;
	}

	public void setAccountName(String accountName) {
		System.out.println(getClass() + " : set accountName");
		this.accountName = accountName;
	}

	@LogExecutionTime
	public String getServiceCode() {
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	@LogExecutionTime
	public List<Account> findAccounts(boolean trip) {

		if (trip) {
			throw new RuntimeException("Runtime Exception. TripWire = " + trip);
		}

		List<Account> myAccounts = new ArrayList<Account>();

		// create sample accounts & add them to list
		myAccounts.add(new Account("John", 111));
		myAccounts.add(new Account("Bill", 112));
		myAccounts.add(new Account("mark", 113));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return myAccounts;
	}
}
