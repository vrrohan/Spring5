package com.ron.springrest.controller;

/*
 * This custom error response class will be sent back to client as JSON. We define Java POJO class. 
 * We define any fields we want to track. Jackson will handle it automatically internally & convert it into JSON.
 */
public class StudentErrorResponse {

	public int status;
	public String message;
	public long timeStamp;

	public StudentErrorResponse(int status, String message, long timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public StudentErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
