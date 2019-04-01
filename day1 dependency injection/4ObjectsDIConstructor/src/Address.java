
public class Address {
	public String streetNo;
	public String city;
	public String state;
	public int zipcode;

	@Override
	public String toString() {
		return "Address {streetNo=" + streetNo + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "}";
	}

	
	public Address(String streetNo, String city, String state, int zipcode) {
		this.streetNo = streetNo;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}


	public String getStreetNo() {
		return streetNo;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public int getZipcode() {
		return zipcode;
	}

}
