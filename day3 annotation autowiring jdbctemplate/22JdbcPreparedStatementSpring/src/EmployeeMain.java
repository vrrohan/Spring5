import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		appContext.registerShutdownHook();

		EmployeeEmpl emp = (EmployeeEmpl) appContext.getBean("emp");
		System.out.println("Total number of Employees are : " + emp.getNumberOfEmployees());

		boolean isEmployeeUpdated = emp.addNewEmployee("Paul", "Pogba", "paul10.fr@gmail.com", "intern", "france",
				50000);
		if (isEmployeeUpdated) {
			System.out.println("New Employee added.");
		} else {
			System.out.println("Unable to add new employee.");
		}

	}

}
