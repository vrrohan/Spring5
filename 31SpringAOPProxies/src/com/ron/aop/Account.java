package com.ron.aop;

public class Account {

	public String name;
	public int id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(String name, int id) {
		this.name = name;
		this.id = id;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", id=" + id + "]";
	}

}
