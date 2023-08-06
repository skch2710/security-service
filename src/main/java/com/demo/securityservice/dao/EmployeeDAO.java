package com.demo.securityservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.securityservice.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Long> {

	Employee findByEmailId(String emailId);
	
	Employee findByEmailIdIgnoreCase(String emailId);

}
