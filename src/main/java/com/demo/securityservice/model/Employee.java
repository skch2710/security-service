package com.demo.securityservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employees",schema="public")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empid")
	private Long empId;
	
	@Column(name="emailid")
	private String emailId;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="password_salt")
	private String password;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	private EmployeeRole employeeRole;
	
}
