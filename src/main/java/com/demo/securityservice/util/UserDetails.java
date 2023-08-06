package com.demo.securityservice.util;

import org.springframework.security.core.userdetails.User;

import com.demo.securityservice.dto.EmployeeDTO;

public class UserDetails extends User{

	public UserDetails(EmployeeDTO user) {
		super(user.getUserName(),user.getPassword(),user.getAuthorittyList());
	}
	
}
