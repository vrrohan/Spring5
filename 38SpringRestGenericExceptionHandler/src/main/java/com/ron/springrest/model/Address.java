package com.ron.springrest.model;

public class Address {

	public String streetNo;
	public String cityName;
	public String countryName;
	public String zipcode;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(String streetNo, String cityName, String countryName, String zipcode) {
		super();
		this.streetNo = streetNo;
		this.cityName = cityName;
		this.countryName = countryName;
		this.zipcode = zipcode;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Address [streetNo=" + streetNo + ", cityName=" + cityName + ", countryName=" + countryName
				+ ", zipcode=" + zipcode + "]";
	}

}
