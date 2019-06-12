package com.ron.springrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ron.springrest.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		List<Employee> allEmployees = currentSession.createQuery("from Employee", Employee.class).getResultList();
		// return the results
		return allEmployees;
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the employee
		currentSession.saveOrUpdate(employee);

	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// now retrieve/read from database using the primary key
		Employee employeeObjectById = currentSession.get(Employee.class, employeeId);
		return employeeObjectById;
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Employee where employeeId=:empId");
		theQuery.setParameter("empId", employeeId);
		theQuery.executeUpdate();
	}

}
