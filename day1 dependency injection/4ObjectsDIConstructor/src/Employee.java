
public class Employee {
	public PersonalDetails personal;
	public Address address;
	public String designation;
	public int salary;

	public Employee(PersonalDetails personal, Address address, String designation, int salary) {
		this.personal = personal;
		this.address = address;
		this.designation = designation;
		this.salary = salary;
	}

	public PersonalDetails getPersonal() {
		return personal;
	}

	public Address getAddress() {
		return address;
	}

	public String getDesignation() {
		return designation;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return personal + ", " + address + ", designation=" + designation + ", salary=" + salary;
	}

}
