import java.util.List;

public interface EmployeeDao {
	public int getNumberOfEmployees();

	public Employee getEmployeeById(int employeeId);
	
	public List<Employee> getAllEmployees();
	
	public int addNewEmployee(String firstName, String lastName, String email, String designation, String location, int salary);
	
	public int updateEmployeeMailById(int employeeId, String email);
	
	public int updateEmployeeDesigById(int employeeId, String desig);
	
	public boolean deleteEmployeeById(int employeeId);
	
	public boolean deleteEmployeeByEmail(String email);
}
