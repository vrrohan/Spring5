package com.ron.springrest.controller;

/*
 * This class will be used by our rest service. If we dont find any student with id passed as param, we throw object of this custom exception class.
 */
public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

}
