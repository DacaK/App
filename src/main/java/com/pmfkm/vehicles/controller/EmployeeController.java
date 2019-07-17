package com.pmfkm.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmfkm.vehicles.model.Employee;
import com.pmfkm.vehicles.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getEmploees")
	public List<Employee> getAllEmployees(){
		return  employeeService.getAllEmployees();
	}

}