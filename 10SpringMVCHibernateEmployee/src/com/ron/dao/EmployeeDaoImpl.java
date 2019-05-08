package com.ron.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ron.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create query
		Query<Employee> queryResult = currentSession.createQuery("from Employee", Employee.class);
		// execute query & get result
		List<Employee> employeeList = queryResult.getResultList();
		// return result in form of list
		return employeeList;
	}

	@Override
	public void saveEmployeeDetails(Employee employeeAddDetails) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(employeeAddDetails);
	}

	@Override
	public void updateEmployeeDetails(Employee employeeUpdateDetails) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(employeeUpdateDetails);
	}

	@Override
	public Employee getEmployeeDetailsById(int employeeId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		return currentSession.get(Employee.class, employeeId);
	}

	@Override
	public boolean getAdminLoginDetails(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteEmployeeDetails(int employeeIdToDelete) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<?> queryToDeleteEmployeeById = currentSession.createQuery("delete from Employee where employeeId=:empId").setParameter("empId", employeeIdToDelete);
		queryToDeleteEmployeeById.executeUpdate();
	}

}
