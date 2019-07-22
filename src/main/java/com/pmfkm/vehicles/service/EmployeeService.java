package com.pmfkm.vehicles.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pmfkm.vehicles.model.Employee;


public interface EmployeeService  extends UserDetailsService
{

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
	Employee saveEmployee(Employee employee);
	
	List<Employee>getAllEmployees();
	
	public Employee getEmployeeByUsername(String username);
}
