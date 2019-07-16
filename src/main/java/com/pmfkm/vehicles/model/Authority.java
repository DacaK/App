package com.pmfkm.vehicles.model;



import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the AUTHORITY database table.
 * 
 */
@Entity
@NamedQuery(name="Authority.findAll", query="SELECT a FROM Authority a")
public class Authority implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id 
	@Column(name="id")
	private long id;

	@Column(name="ROLE_TITLE")
	private String role;

	//bi-directional many-to-one association to Employee
	
	@OneToMany(mappedBy="authority")
	@JsonIgnore
	private List<Employee> employees;

	public Authority() {
	}
	
	public Authority(long id) {
		this.id = id;
	}
	 
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setAuthority(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setAuthority(null);

		return employee;
	}

}