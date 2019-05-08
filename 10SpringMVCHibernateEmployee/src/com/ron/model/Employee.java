package com.ron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

	private static final String EMPTY_FIRSTNAME_ERROR_MESSAGE = "Firstname is required, cannot be kept empty.";
	private static final String SIZE_LIMIT_FIRSTNAME_ERROR_MESSAGE = "Firstname must be between 2 to 30 characters long";
	private static final String VALID_EMAIL_ERROR_MESSAGE = "Please enter a valid email";
	private static final int MINIMUM_FIRSTNAME_LENGTH = 2;
	private static final int MAXIMUM_FIRSTNAME_LENGTH = 30;
	private static final String EMAIL_VALIDATOR_REGEX_PATTERN = "^[a-zA-Z]{1}[a-zA-Z0-9.-_]{3,10}@[a-zA-Z]{3,6}(.com|.co.in)";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "Please fill email address.";
	private static final String EMPTY_LASTNAME_ERROR_MESSAGE = "Lastname is required, cannot be kept empty.";
	private static final int MAXIMUM_LASTNAME_LENGTH = 30;
	private static final String EMPTY_DESIGNATION_ERROR_MESSAGE = "Designation is required, cannot be kept empty.";
	private static final int MINIMUM_LASTNAME_LENGTH = 2;
	private static final String SIZE_LIMIT_LASTNAME_ERROR_MESSAGE = "Lastname must be between 2 to 30 characters long";

	@Id
	@Column(name = "employeeId")
	public int employeeId;

	@NotNull(message = EMPTY_FIRSTNAME_ERROR_MESSAGE)
	@Size(min = MINIMUM_FIRSTNAME_LENGTH, max = MAXIMUM_FIRSTNAME_LENGTH, message = SIZE_LIMIT_FIRSTNAME_ERROR_MESSAGE)
	@Column(name = "firstname")
	public String firstname;

	@NotNull(message = EMPTY_LASTNAME_ERROR_MESSAGE)
	@Size(min = MINIMUM_LASTNAME_LENGTH, max = MAXIMUM_LASTNAME_LENGTH, message = SIZE_LIMIT_LASTNAME_ERROR_MESSAGE)
	@Column(name = "lastname")
	public String lastname;

	@NotNull(message = EMPTY_EMAIL_ERROR_MESSAGE)
	@Pattern(regexp = EMAIL_VALIDATOR_REGEX_PATTERN, message = VALID_EMAIL_ERROR_MESSAGE)
	@Column(name = "email")
	public String email;

	@NotNull(message = EMPTY_DESIGNATION_ERROR_MESSAGE)
	@Column(name = "designation")
	public String designation;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
