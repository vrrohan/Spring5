package com.ron.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Person implements Serializable {

	private static final String EMPTY_FIRSTNAME_ERROR_MESSAGE = "Firstname is required, cannot be kept empty.";
	private static final String SIZE_LIMIT_FIRSTNAME_ERROR_MESSAGE = "Firstname must be between 2 to 30 characters long";
	private static final String MINIMUM_AGE_ERROR_MESSAGE = "Minimum Age must be above 8";
	private static final String MAXIMUM_AGE_ERROR_MESSAGE = "Maximum Age must be below 60";
	private static final String VALID_EMAIL_ERROR_MESSAGE = "Please enter a valid email";
	private static final int MINIMUM_FIRSTNAME_LENGTH = 2;
	private static final int MAXIMUM_FIRSTNAME_LENGTH = 30;
	private static final int MINIMUM_AGE_LIMIT = 8;
	private static final int MAXIMUM_AGE_LIMIT = 65;
	/*
	 * Email Regex validation :- 1) Must start with either a-z or A-Z, cannot start
	 * email with digit, hence ^[a-zA-Z], ^ is for start 2) ^[a-zA-Z]{1} means start
	 * email with atleast alphabet of length 1. {1,} - means atleast length of 1 3)
	 * [a-zA-Z0-9.-_]{3,10} means, email contains any thing from a-z or A-Z or
	 * between digits 0-9 or can include . _ or - minimum length 3 & maximum length
	 * 10 before @ 4) @ symbol followed by [domain name a-z or A-Z] again of minimum
	 * length 3 & maximum length of 6 5) Atlast email must end with either .com or
	 * .co.in, only these 2 specific names are allowed
	 */
	private static final String EMAIL_VALIDATOR_REGEX_PATTERN = "^[a-zA-Z]{1}[a-zA-Z0-9.-_]{3,10}@[a-zA-Z]{3,6}(.com|.co.in)";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "Please fill email address.";
	private static final String DEFAULT_ZERO_AGE_EMPTY_FIELD_ERROR_MESSAGE = "Age is Required.";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@NotNull(message = EMPTY_FIRSTNAME_ERROR_MESSAGE)
	@Size(min = MINIMUM_FIRSTNAME_LENGTH, max = MAXIMUM_FIRSTNAME_LENGTH, message = SIZE_LIMIT_FIRSTNAME_ERROR_MESSAGE)
	public String firstname;
	public String lastname;

	@NotNull(message = EMPTY_EMAIL_ERROR_MESSAGE)
	@Pattern(regexp = EMAIL_VALIDATOR_REGEX_PATTERN, message = VALID_EMAIL_ERROR_MESSAGE)
	public String email;
	public String gender;

	@NotNull(message = DEFAULT_ZERO_AGE_EMPTY_FIELD_ERROR_MESSAGE)
	@Min(value = MINIMUM_AGE_LIMIT, message = MINIMUM_AGE_ERROR_MESSAGE)
	@Max(value = MAXIMUM_AGE_LIMIT, message = MAXIMUM_AGE_ERROR_MESSAGE)
	public Integer age;
	public String mealType;
	public String[] meals;
	public String dateOfTravel;
	public String fromCity;
	public String toCity;

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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String[] getMeals() {
		return meals;
	}

	public void setMeals(String[] meals) {
		this.meals = meals;
	}

	public String getDateOfTravel() {
		return dateOfTravel;
	}

	public void setDateOfTravel(String dateOfTravel) {
		this.dateOfTravel = dateOfTravel;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

}
