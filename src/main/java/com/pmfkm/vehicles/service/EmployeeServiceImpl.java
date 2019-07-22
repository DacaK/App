package com.pmfkm.vehicles.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmfkm.vehicles.config.JwtUserFactory;
import com.pmfkm.vehicles.dao.EmployeeDao;
import com.pmfkm.vehicles.model.Authority;
import com.pmfkm.vehicles.model.Employee;



@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Transactional
	public Employee saveEmployee(Employee employee) {
		
		Authority autority = new Authority();
		
		autority.setId(2);
		employee.setIsActive(true);
		employee.setAuthority(autority);
		employee.setPassword(bcryptEncoder.encode(employee.getPassword()));
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee employee = employeeDao.findByUsername(username);
		
		if(employee == null) {
			throw new UsernameNotFoundException("User not found with username:"+username);
		}
		
	    return new User(employee.getUsername(), employee.getPassword(), maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE_"+employee.getAuthority().getRole()))));
	}
	

	private static List<GrantedAuthority> maptoGrantedAuthorities(List<String> authorities) {
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority)).collect(Collectors.toList());
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		return employeeDao.findByUsername(username);
	}


	
	


}


