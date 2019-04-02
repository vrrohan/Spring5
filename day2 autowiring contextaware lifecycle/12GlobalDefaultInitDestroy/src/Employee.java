import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		return "Employee [empName=" + empName + ", desig=" + desig + ", salary=" + salary + ", compDetails="
				+ compDetails + ", empAddress=" + empAddress + "]";
	}

	/*
	 * @Override public void afterPropertiesSet() throws Exception { // TODO
	 * Auto-generated method stub
	 * System.out.println("initializing init method..."); }
	 * 
	 * @Override public void destroy() throws Exception { // TODO Auto-generated
	 * method stub
	 * System.out.println("beans are destroyed... destroy() method is called");
	 * }
	 */
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/test";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public void myInit() {
		System.out.println("Spring Employee Bean is initialized...");
		try (Connection c = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD); Statement s = c.createStatement(); ResultSet rs = s.executeQuery("select * from employee")) {
			System.out.println("Connection created successfully...");
			while(rs.next()) {
				System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getString(4) + ", " + rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void cleanUp() {
		System.out.println("Spring Employee Bean is Cleaned up...");
	}
}
