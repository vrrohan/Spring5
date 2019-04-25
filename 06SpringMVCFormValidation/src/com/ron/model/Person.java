package com.ron.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person implements Serializable {

	private static final String EMPTY_FIRSTNAME_ERROR_MESSAGE = "Firstname is required, cannot be kept empty.";
	private static final String SIZE_LIMIT_FIRSTNAME_ERROR_MESSAGE = "Firstname must be between 2 to 30 characters long";
	private static final String MINIMUM_AGE_ERROR_MESSAGE = "Minimum Age must be above 8";
	private static final String MAXIMUM_AGE_ERROR_MESSAGE = "Maximum Age must be below 60";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}

	@NotNull(message = EMPTY_FIRSTNAME_ERROR_MESSAGE)
	@Size(min = 2, max = 30, message = SIZE_LIMIT_FIRSTNAME_ERROR_MESSAGE)
	public String firstname;
	public String lastname;
	public String email;
	public String gender;

	@Min(value = 8, message = MINIMUM_AGE_ERROR_MESSAGE)
	@Max(value = 60, message = MAXIMUM_AGE_ERROR_MESSAGE)
	public int age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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
