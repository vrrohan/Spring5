public class Employee {
	public String empName;
	public String desig;
	public int salary;
	public Company compDetails;
	public Address empAddress;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Company getCompDetails() {
		return compDetails;
	}

	public void setCompDetails(Company compDetails) {
		this.compDetails = compDetails;
	}

	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}

	@Override
	public String toString() {
		return "Employee name is " + empName + " working as " + desig + ". His salary is " + salary + "\n" + compDetails + "\n" + empAddress;
	}

}
