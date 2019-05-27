package com.ron.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addMemberAccount() {
		System.out.println("Add Membership Account : " + getClass() + " : Adding a membership account.");
	}

}
