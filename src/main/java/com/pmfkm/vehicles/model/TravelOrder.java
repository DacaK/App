package com.pmfkm.vehicles.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the TRAVEL_ORDER database table.
 * 
 */
@Entity
@Table(name="TRAVEL_ORDER")
@NamedQuery(name="TravelOrder.findAll", query="SELECT t FROM TravelOrder t")
public class TravelOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="ACT_DISTANCE")
	private int actDistance;

	@Column(name="ADMIN_NOTE")
	private String adminNote;

	@Column(name="CREATED_AT")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_END")
	private Date dateEnd;

	@Temporal(TemporalType.DATE)
	@Column(name="DATE_START")
	private Date dateStart;

	@NotNull(message="Destination is required")
	private String destination;

	@Column(name="EMP_NOTE")
	private String empNote;

	@Column(name="EST_DISTANCE")
	private int estDistance;

	@Column(name="FUEL_CONSUMED")
	private float fuelConsumed;

	//bi-directional many-to-one association to Bill
	@OneToMany(mappedBy="travelOrder")
	@JsonIgnore
	private List<Bill> bills;

	//bi-directional many-to-one association to Employee
	@NotNull(message="Employee is required")
	@ManyToOne
	private Employee employee;

	//bi-directional many-to-one association to TravelStatus
	@ManyToOne
	@JoinColumn(name="TRAVEL_STATUS_ID")
	private TravelStatus travelStatus;

	//bi-directional many-to-one association to Vehicle
	@NotNull(message="Vehicle is required")
	@ManyToOne
	private Vehicle vehicle;

	public TravelOrder() {
	}

	public TravelOrder(int id, int actDistance, String adminNote, Timestamp createdAt, Date dateEnd, Date dateStart,
			String destination, String empNote, int estDistance, float fuelConsumed, List<Bill> bills,
			Employee employee, TravelStatus travelStatus, Vehicle vehicle) {
		this.id = id;
		this.actDistance = actDistance;
		this.adminNote = adminNote;
		this.createdAt = createdAt;
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.destination = destination;
		this.empNote = empNote;
		this.estDistance = estDistance;
		this.fuelConsumed = fuelConsumed;
		this.bills = bills;
		this.employee = employee;
		this.travelStatus = travelStatus;
		this.vehicle = vehicle;
	}

	public TravelOrder(int actDistance, String adminNote, Timestamp createdAt, Date dateEnd, Date dateStart,
			String destination, String empNote, int estDistance, float fuelConsumed, List<Bill> bills,
			Employee employee, TravelStatus travelStatus, Vehicle vehicle) {
		this.actDistance = actDistance;
		this.adminNote = adminNote;
		this.createdAt = createdAt;
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.destination = destination;
		this.empNote = empNote;
		this.estDistance = estDistance;
		this.fuelConsumed = fuelConsumed;
		this.bills = bills;
		this.employee = employee;
		this.travelStatus = travelStatus;
		this.vehicle = vehicle;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getActDistance() {
		return this.actDistance;
	}

	public void setActDistance(int actDistance) {
		this.actDistance = actDistance;
	}

	public String getAdminNote() {
		return this.adminNote;
	}

	public void setAdminNote(String adminNote) {
		this.adminNote = adminNote;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Date getDateStart() {
		return this.dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getEmpNote() {
		return this.empNote;
	}

	public void setEmpNote(String empNote) {
		this.empNote = empNote;
	}

	public int getEstDistance() {
		return this.estDistance;
	}

	public void setEstDistance(int estDistance) {
		this.estDistance = estDistance;
	}

	public float getFuelConsumed() {
		return this.fuelConsumed;
	}

	public void setFuelConsumed(float fuelConsumed) {
		this.fuelConsumed = fuelConsumed;
	}

	public List<Bill> getBills() {
		return this.bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	public Bill addBill(Bill bill) {
		getBills().add(bill);
		bill.setTravelOrder(this);

		return bill;
	}

	public Bill removeBill(Bill bill) {
		getBills().remove(bill);
		bill.setTravelOrder(null);

		return bill;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public TravelStatus getTravelStatus() {
		return this.travelStatus;
	}

	public void setTravelStatus(TravelStatus travelStatus) {
		this.travelStatus = travelStatus;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}