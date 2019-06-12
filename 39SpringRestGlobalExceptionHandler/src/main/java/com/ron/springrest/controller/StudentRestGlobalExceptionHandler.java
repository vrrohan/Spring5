package com.ron.springrest.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestGlobalExceptionHandler {

	private final Logger logger = Logger.getLogger(this.getClass().getName());

	// add exception handling code here
	// our exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException) {
		logger.info("***StudentNotFoundException Caught***");
		// create student error response
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		studentErrorResponse.setMessage(studentNotFoundException.getMessage());
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());
		// return response entity
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.NOT_FOUND);
	}

	// add a new exception handler - to catch any exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception excep) {
		logger.info("***BAD REQUEST Exception Caught***");
		// create student error response
		StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
		studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		studentErrorResponse.setMessage("Invalid Input - Alphabets Entered");
		studentErrorResponse.setTimeStamp(System.currentTimeMillis());
		// return response entity
		return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.NOT_FOUND);

	}
}
