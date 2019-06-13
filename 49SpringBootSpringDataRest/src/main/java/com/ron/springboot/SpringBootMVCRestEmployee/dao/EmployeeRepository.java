package com.ron.springboot.SpringBootMVCRestEmployee.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ron.springboot.SpringBootMVCRestEmployee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
