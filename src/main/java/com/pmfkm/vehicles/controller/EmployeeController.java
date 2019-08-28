package com.pmfkm.vehicles.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmfkm.vehicles.model.Employee;
import com.pmfkm.vehicles.model.TravelOrder;
import com.pmfkm.vehicles.service.EmployeeService;

@CrossOrigin("http://localhost:4200")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/getEmployees")
	@PreAuthorize("hasRole('ADMIN')")
	public List<Employee> getAllEmployees() throws AccessDeniedException{
		return  employeeService.getAllEmployees();
	}
	

	@GetMapping("/getEmployee")
	public Employee getEmployee(Principal principal) {
		Employee user = employeeService.getEmployeeByUsername(principal.getName());
		return  user;
	}
	
	@GetMapping("/usertravelorders/{username}")
	public List<TravelOrder> allTravelOrderForUser(@PathVariable("username") String username){
		return employeeService.allUserTravelOrders(username);
	}
 
	@GetMapping("/employee/{id}")
	public Optional<Employee> findById(@PathVariable("id") int id) {
		return employeeService.findById(id);			
	}
	
	@PutMapping("/deactivate/{id}")
	public void deactivateEmployee(int id) {
		employeeService.deactivateEmployee(id);
	}
	
	@PutMapping("/activate/{id}")
	public void activateEmployee(int id) {
		employeeService.activateEmployee(id);
	}

}
