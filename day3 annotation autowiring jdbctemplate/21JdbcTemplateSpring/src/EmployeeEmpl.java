import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeEmpl implements EmployeeDao {

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public int getNumberOfEmployees() {
		// TODO Auto-generated method stub
		return template.queryForObject("select count(*) from employee", Integer.class);
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		try {
			return template.queryForObject("select * from employee where empid = ?", new Object[] { employeeId },
					new RowMapper<Employee>() {
						@Override
						public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
							// TODO Auto-generated method stub
							Employee emp = new Employee();
							emp.setEmployeeId(rs.getInt("empid"));
							emp.setFirstName(rs.getString("fname"));
							emp.setLastName(rs.getString("lname"));
							emp.setEmail(rs.getString("email"));
							emp.setDesignation(rs.getString("desig"));
							emp.setLocation(rs.getString("location"));
							emp.setSalary(rs.getInt("salary"));
							return emp;
						}

					});

		} catch (EmptyResultDataAccessException excep) {
			return null;
		}
	}

	@Override
	public int addNewEmployee(String firstName, String lastName, String email, String designation, String location,
			int salary) {
		// TODO Auto-generated method stub
		return template.update(
				"insert into employee(fname, lname, email, desig, location, salary) values(?, ?, ?, ?, ?, ?)",
				firstName, lastName, email, designation, location, salary);
	}

	@Override
	public int updateEmployeeMailById(int employeeId, String email) {
		// TODO Auto-generated method stub
		if (getEmployeeById(employeeId) == null) {
			return -1;
		} else {
			return template.update("update employee set email = ? where empid = ?", email, employeeId);

		}
	}

	@Override
	public int updateEmployeeDesigById(int employeeId, String desig) {
		// TODO Auto-generated method stub
		if (getEmployeeById(employeeId) == null) {
			return -1;
		} else {
			return template.update("update employee set desig = ? where empid = ?", desig, employeeId);
		}
	}

	@Override
	public boolean deleteEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		int isDeleted = template.update("delete from employee where empid = ?", employeeId);
		if (isDeleted > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteEmployeeByEmail(String email) {
		// TODO Auto-generated method stub
		int isDeleted = template.update("delete from employee where email = ?", email);
		if (isDeleted > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		try {
			List<Employee> empList = new ArrayList<Employee>();
			List<Map<String, Object>> rows = template.queryForList("select * from employee");
			for(Map<?, ?> rowNum : rows) {
				Employee emp = new Employee();
				emp.setEmployeeId((Integer)rowNum.get("empid"));
				emp.setFirstName((String)rowNum.get("fname"));
				emp.setLastName((String)rowNum.get("lname"));
				emp.setEmail((String)rowNum.get("email"));
				emp.setDesignation((String)rowNum.get("desig"));
				emp.setLocation((String)rowNum.get("location"));
				emp.setSalary((Integer)rowNum.get("salary"));
				empList.add(emp);
			}
			return empList;
		} catch (DataAccessException excep) {
			return null;
		}
	}

}
