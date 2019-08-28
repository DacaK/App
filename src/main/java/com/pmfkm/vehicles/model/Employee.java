package com.pmfkm.vehicles.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	@NotNull(message="Email is required!")
	@Email
	private String email;

	@NotNull(message="First name is required!")
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="IS_ACTIVE")
	private boolean isActive;

	@NotNull(message="Last name is required!")
	@Column(name="LAST_NAME")
	private String lastName;
	
	@NotNull(message="Password is required!")
	@Column(name="PASS")
	private String password;

	@NotNull(message="Username is required!")
	private String username;

	//bi-directional many-to-one association to Authority
	@ManyToOne
	private Authority authority;

	//bi-directional many-to-one association to TravelOrder
	@OneToMany(mappedBy="employee")
	@JsonIgnore
	private List<TravelOrder> travelOrders;

	public Employee() {
	}

	public Employee(int id, String firstName, String lastName, String email, String username, String password,
			boolean isActive, Authority authority, List<TravelOrder> travelOrders) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.authority = authority;
		this.travelOrders = travelOrders;
	}
	
	public Employee(String firstName, String lastName, String email, String username, String password,
			boolean isActive, Authority authority, List<TravelOrder> travelOrders) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.isActive = isActive;
		this.authority = authority;
		this.travelOrders = travelOrders;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Authority getAuthority() {
		return this.authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public List<TravelOrder> getTravelOrders() {
		return this.travelOrders;
	}

	public void setTravelOrders(List<TravelOrder> travelOrders) {
		this.travelOrders = travelOrders;
	}

	public TravelOrder addTravelOrder(TravelOrder travelOrder) {
		getTravelOrders().add(travelOrder);
		travelOrder.setEmployee(this);

		return travelOrder;
	}

	public TravelOrder removeTravelOrder(TravelOrder travelOrder) {
		getTravelOrders().remove(travelOrder);
		travelOrder.setEmployee(null);

		return travelOrder;
	}

}