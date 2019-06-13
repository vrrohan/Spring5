package com.ron.springboot.SpringBootMVCRestEmployee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ron.springboot.SpringBootMVCRestEmployee.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager hibernateEntityManager;

	public EntityManager getHibernateEntityManager() {
		return hibernateEntityManager;
	}

	public void setHibernateEntityManager(EntityManager hibernateEntityManager) {
		this.hibernateEntityManager = hibernateEntityManager;
	}

	// constructor injection by spring boot
	@Autowired
	public EmployeeDaoImpl(EntityManager hibernateEntityManager) {
		this.hibernateEntityManager = hibernateEntityManager;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		// get current hibernate session
		Session currentSession = hibernateEntityManager.unwrap(Session.class);
		List<Employee> allEmployees = currentSession.createQuery("from Employee", Employee.class).getResultList();
		return allEmployees;
	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Session currentSession = hibernateEntityManager.unwrap(Session.class);
		return currentSession.get(Employee.class, employeeId);
	}

	@Override
	public void saveNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Session currentSession = hibernateEntityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@Override
	public void deleteEmployeeById(int employeeId) {
		// TODO Auto-generated method stub
		Session currentSession = hibernateEntityManager.unwrap(Session.class);
		Query query = currentSession.createQuery("delete from Employee where employeeId=:empId");
		query.setParameter("empId", employeeId);
		query.executeUpdate();
	}

}
