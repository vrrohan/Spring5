public interface EmployeeDao {
	
	public int getNumberOfEmployees();

	public Employee getEmployeeById(int employeeId);
	
	public boolean addNewEmployee(String firstName, String lastName, String email, String desig, String location, int salary);
	
}
