package com.demo.securityservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "emp_roles", schema = "public")
@JsonIgnoreProperties(ignoreUnknown = true, value = { "employee" })
public class EmployeeRole {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empRoleId;

	@OneToOne
	@JoinColumn(name = "emp_id", nullable = true)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "role_id", nullable = true)
	private Roles role;

	private Date roleStartDate;

	private Date roleEndDate;

	private boolean isActive;

}
