package com.ron.springrest.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestGlobalExceptionHandler {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	// add exception handling code here
	// our exception handler
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException employeeNotFoundException) {
		logger.info("***EmployeeNotFoundException Caught***");
		// create student error response
		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
		employeeErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		employeeErrorResponse.setMessage(employeeNotFoundException.getMessage());
		employeeErrorResponse.setTimeStamp(System.currentTimeMillis());
		// return response entity
		return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse, HttpStatus.NOT_FOUND);
	}

	// add a new exception handler - to catch any exception
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(Exception excep) {
		logger.info("***BAD REQUEST Exception Caught***");
		// create student error response
		EmployeeErrorResponse employeeErrorResponse = new EmployeeErrorResponse();
		employeeErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		employeeErrorResponse.setMessage("Invalid Input - Alphabets Entered");
		employeeErrorResponse.setTimeStamp(System.currentTimeMillis());
		// return response entity
		return new ResponseEntity<EmployeeErrorResponse>(employeeErrorResponse, HttpStatus.NOT_FOUND);

	}
}
