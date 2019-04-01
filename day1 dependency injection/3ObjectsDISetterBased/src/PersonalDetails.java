
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
