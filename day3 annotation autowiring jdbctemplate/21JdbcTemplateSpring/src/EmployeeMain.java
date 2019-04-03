import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");
		appContext.registerShutdownHook();
		
		EmployeeEmpl  emp = (EmployeeEmpl) appContext.getBean("emp");
		System.out.println("Total number of Employees are : " + emp.getNumberOfEmployees());
		
/*		int empUpdated = emp.addNewEmployee("Leo", "Messi", "leo10barca@gmail.com", "architect", "spain", 1200000);
		if (empUpdated > 0) {
			System.out.println("New Employee added.");
		}
		else {
			System.out.println("Unable to add new employee.");
		}
*/		
		Employee empById = emp.getEmployeeById(1120);
		System.out.println(empById);
		
		int idToUpdate = 124;
		String newUpdatedEmail = "spring5.0@gmail.com";
		int isEmployeeUpdated = emp.updateEmployeeMailById(idToUpdate, newUpdatedEmail);
		if(isEmployeeUpdated == -1) {
			System.out.println("No Employee with id " + idToUpdate + " is present.");
		}
		else {
			System.out.println("Employee with id " + idToUpdate + " is updated with new email : " + newUpdatedEmail);
		}
		
		int idToUpdateDesig = 106;
		String desigToUpdate = "CEO";
		int isEmployeeDesigUpdated = emp.updateEmployeeDesigById(idToUpdateDesig, desigToUpdate);
		if(isEmployeeDesigUpdated == -1) {
			System.out.println("No Employee with id " + idToUpdateDesig + " is present.");
		}
		else {
			System.out.println("Employee with id " + idToUpdateDesig + " is updated with new designation : " + desigToUpdate);
		}
		
		String emailToDelete = "way99@yahoo.com";
		if(emp.deleteEmployeeByEmail(emailToDelete)) {
			System.out.println("Email " + emailToDelete + " deleted.");
		}
		else {
			System.out.println("Unable to delete email " + emailToDelete);
		}
		
		List<Employee> allEmployeesList = emp.getAllEmployees();
		allEmployeesList.forEach(x -> System.out.println(x));
	}

}
