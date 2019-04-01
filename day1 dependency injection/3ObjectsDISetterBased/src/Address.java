
public class Address {
	public String streetNo;
	public String city;
	public String state;
	public int zipcode;

	@Override
	public String toString() {
		return "Address {streetNo=" + streetNo + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + "}";
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

}
