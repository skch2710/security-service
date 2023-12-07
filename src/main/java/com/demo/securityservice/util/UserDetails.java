package com.demo.securityservice.util;

import org.springframework.security.core.userdetails.User;

import com.demo.securityservice.dto.EmployeeDTO;

public class UserDetails extends User{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDetails(EmployeeDTO user) {
		super(user.getUserName(),user.getPassword(),user.getAuthorittyList());
	}
	
}
