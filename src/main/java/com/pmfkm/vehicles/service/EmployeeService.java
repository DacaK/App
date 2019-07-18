package com.pmfkm.vehicles.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.pmfkm.vehicles.model.Employee;


public interface EmployeeService  extends UserDetailsService
{

	Employee saveEmployee(Employee employee);
	
	List<Employee>getAllEmployees();
	
	public UserDetails loadUserByUsername(String username);
	
}
