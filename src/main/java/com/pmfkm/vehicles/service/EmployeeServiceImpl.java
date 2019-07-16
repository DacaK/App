package com.pmfkm.vehicles.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pmfkm.vehicles.dao.EmployeeDao;
import com.pmfkm.vehicles.model.Authority;
import com.pmfkm.vehicles.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	
//	private PasswordEncoder bcryptEncoder;
	
	@Transactional
	public Employee saveEmployee(Employee employee) {
		
		Authority autority = new Authority();
		autority.setId(2);
		employee.setAuthority(autority);
//		employee.setPass(bcryptEncoder.encode(employee.getPass()));
		System.out.println(employee);
		return employeeDao.save(employee);
	}

}


