package com.demo.securityservice.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Data
@Table(name="employees",schema="login")
public class Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;
	
	private String emailId;
	
	private String firstName;
	
	private String lastName;
	
	private String passwordSalt;
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
	private EmployeeRole employeeRole;
	
	@Transient
	private String otp;
	
	private Long createdById;
	
	private Date createdDate;
	
	private Long modifiedById;
	
	private Date modifiedDate;
}
