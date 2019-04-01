
public class Employee {
	public PersonalDetails personal;
	public Address address;
	public String designation;
	public int salary;

	public PersonalDetails getPersonal() {
		return personal;
	}

	public void setPersonal(PersonalDetails personal) {
		this.personal = personal;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return personal + ", " + address + ", designation=" + designation + ", salary=" + salary;
	}

}
