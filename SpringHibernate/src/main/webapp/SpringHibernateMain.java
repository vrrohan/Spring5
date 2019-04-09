package main.webapp;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringHibernateMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("main/webapp/WEB-INF/applicationContext.xml");
		EmployeeDao employeeDao = con.getBean(EmployeeDao.class);
		
		List<Employee> empList = employeeDao.getAllEmployees();
		
		for(Employee e:empList) {
			System.out.println(e.getFirstName());
		}
	}

}
