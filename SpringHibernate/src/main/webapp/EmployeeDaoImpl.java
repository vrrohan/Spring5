package main.webapp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class EmployeeDaoImpl implements EmployeeDao {

	public SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<Employee> employeeList = session.createQuery("from Employee").list();
		session.close();
		return employeeList;
	}

}
