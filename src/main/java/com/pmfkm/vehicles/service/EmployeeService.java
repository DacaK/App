package com.pmfkm.vehicles.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.pmfkm.vehicles.model.Employee;
import com.pmfkm.vehicles.model.TravelOrder;


public interface EmployeeService  extends UserDetailsService
{

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	Employee saveEmployee(Employee employee);
	List<Employee>getAllEmployees();
	public Employee getEmployeeByUsername(String username);
	
	public List<TravelOrder> allUserTravelOrders(String username);
	public Optional<Employee> findById(int id);
	public void deactivateEmployee(int id);
	public void activateEmployee(int id);
	public boolean isEmailAlreadyInUse(String email);
	public boolean isUsernameAlreadyTaken(String username);
	
	
}
