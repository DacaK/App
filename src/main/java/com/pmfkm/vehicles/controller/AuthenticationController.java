package com.pmfkm.vehicles.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmfkm.vehicles.model.Employee;
import com.pmfkm.vehicles.service.EmployeeService;


@CrossOrigin
@RestController
public class AuthenticationController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@PostMapping(value="/register", consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee saveUser(@RequestBody Employee employee) throws Exception{
		return employeeService.saveEmployee(employee);
	}
}
