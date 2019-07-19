package com.pmfkm.vehicles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
		employee.setAuthority(autority);
		employee.setPassword(bcryptEncoder.encode(employee.getPassword()));
		System.out.println(employee);
		return employeeDao.save(employee);
	}

	@Override
	@Transactional
	public List<Employee> getAllEmployees() {
		System.out.println(employeeDao.findAll());
		return employeeDao.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Employee employee = employeeDao.findByUsername(username);
		if(employee == null) {
			throw new UsernameNotFoundException("User not found with username:"+employee);
		}
//		return new User(employee.getUsername(), employee.getPassword(), new ArrayList<>());
		return JwtUserFactory.create(employee);
		
		
	}

	
	


}


