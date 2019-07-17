package com.pmfkm.vehicles.service;

import java.util.List;

import com.pmfkm.vehicles.model.Employee;


public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee>getAllEmployees();
}
