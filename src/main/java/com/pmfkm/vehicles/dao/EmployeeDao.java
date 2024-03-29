package com.pmfkm.vehicles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmfkm.vehicles.model.Employee;


@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	Employee findByUsername(String username);
	Employee findByEmail(String email);
	Employee findByUsernameAndIsActiveTrue(String username);


}
