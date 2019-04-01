
public class PersonalDetails {
	public String firstName;
	public String lastName;
	public String email;

	@Override
	public String toString() {
		return "PersonalDetails {firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "}";
	}

	public String getFirstName() {
		return firstName;
	}

	public PersonalDetails(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

}
