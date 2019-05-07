package com.ron.dao;

import java.util.List;

import javax.transaction.Transactional;

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
	@Transactional
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

}
