package com.pmfkm.vehicles.model;


import java.io.Serializable;
import javax.persistence.*;
 
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
 
import java.util.List;

 
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
@Table(name="employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="IS_ACTIVE")
	private boolean isActive;

	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PASS")
	private String pass;
	
	
	@ManyToOne
	@JoinColumn(name="AUTHORITY_ID")
	@JsonIgnore
	private Authority authority;

	@OneToMany(mappedBy="employee")
	@JsonIgnore
	private List<TravelOrder> travelOrders;

	public Employee() {
	} 

	public Employee(long id, String email, String firstName, boolean isActive, String lastName, String pass,
			Authority authority, List<TravelOrder> travelOrders) { 
		this.id = id;
		this.email = email;
		this.firstName = firstName;
		this.isActive = isActive;
		this.lastName = lastName;
		this.pass = pass;
		this.authority = authority;
		this.travelOrders = travelOrders;
	} 
	public Employee(String email, String firstName, boolean isActive, String lastName, String pass, Authority authority,
			List<TravelOrder> travelOrders) { 
		this.email = email;
		this.firstName = firstName;
		this.isActive = isActive;
		this.lastName = lastName;
		this.pass = pass;
		this.authority = authority;
		this.travelOrders = travelOrders;
	}  
	
	
 
	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", email=" + email + ", firstName=" + firstName + ", isActive=" + isActive
				+ ", lastName=" + lastName + ", pass=" + pass + ", authority=" + authority + ", travelOrders="
				+ travelOrders + "]";
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
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
	@JsonIgnore
	public String getPass() {
		return this.pass;
	}
	@JsonProperty
	public void setPass(String pass) {
		this.pass = pass;
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
