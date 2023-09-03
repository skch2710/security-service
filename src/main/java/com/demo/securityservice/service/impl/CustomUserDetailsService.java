package com.demo.securityservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.securityservice.dao.EmployeeDAO;
import com.demo.securityservice.dto.EmployeeDTO;
import com.demo.securityservice.model.Employee;


@Service("customUserService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeDAO userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee model = this.userRepository.findByEmailId(username);
		EmployeeDTO userDTO = new EmployeeDTO();
		userDTO.setUserName(model.getEmailId());
		userDTO.setPassword(model.getPasswordSalt());
		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		GrantedAuthority authority = new SimpleGrantedAuthority(model.getEmployeeRole().getRole().getRoleName());
//		GrantedAuthority authority = new SimpleGrantedAuthority(model.getEmployeeRole().getRole().getRoleName()+"-"+model.getEmployeeRole().getRole().isExternalRole());
		grantedAuthorities.add(authority);
		
//		for(UserPrivilege privilege:model.getUserPrivilege()) {
//			String resourceName = privilege.getRolePrivilege().getResource().getResourceName();
//			if(privilege.isReadOnlyFlag()) {
//				String readOnly = resourceName;
//				readOnly = readOnly+"-R";
//				authority = new SimpleGrantedAuthority(readOnly);
//				grantedAuthorities.add(authority);
//			}if(privilege.isReadWriteFlag()) {
//				String readWriteOnly = resourceName;
//				readWriteOnly = readWriteOnly+"-W";
//				authority = new SimpleGrantedAuthority(readWriteOnly);
//				grantedAuthorities.add(authority);
//			}if(privilege.isTerminateFlag()) {
//				String allAccess = resourceName;
//				allAccess = allAccess+"-X";
//				authority = new SimpleGrantedAuthority(allAccess);
//				grantedAuthorities.add(authority);
//			}
//			
//		}

		userDTO.setAuthorittyList(grantedAuthorities);
		com.demo.securityservice.util.UserDetails userDetails = new com.demo.securityservice.util.UserDetails(userDTO);
		return userDetails;
	}

}
