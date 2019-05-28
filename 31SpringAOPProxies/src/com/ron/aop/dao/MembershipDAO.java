package com.ron.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMemberAccount(int num, boolean memFlag, int[] numbers) {
		System.out.println("Add Membership Account : " + getClass() + " : Adding a membership account.");
		return true;
	}

	public int[] getAllAccountsNumbers() {
		System.out.println("Getting all Members account");
		return new int[] { 12345, 12346, 12347, 12348 };
	}

}
