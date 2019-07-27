package com.pmfkm.vehicles.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the VEHICLE database table.
 * 
 */
@Entity
@NamedQuery(name="Vehicle.findAll", query="SELECT v FROM Vehicle v")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;

	private String brand;

	private float consumption;

	private float cubage;

	private int distance;

	@Column(name="IS_ACTIVE")
	private boolean isActive;

	@Column(name="IS_AVAILABLE")
	private boolean isAvailable;

	@Column(name="LAST_SERVICE")
	private int lastService;

	@Column(name="LICENCE_NUM")
	private String licenceNum;

	private String model;

	@Column(name="VEHICLE_NUM")
	private String vehicleNum;

	//bi-directional many-to-one association to ServiceBook
	@OneToMany(mappedBy="vehicle")
	@JsonIgnore
	private List<ServiceBook> serviceBooks;

	//bi-directional many-to-one association to TravelOrder
	@OneToMany(mappedBy="vehicle")
	@JsonIgnore
	private List<TravelOrder> travelOrders;

	public Vehicle() {
	}

	public Vehicle(int id, String brand, float consumption, float cubage, int distance, boolean isActive,
			boolean isAvailable, int lastService, String licenceNum, String model, String vehicleNum,
			List<TravelOrder> travelOrders) {
		this.id = id;
		this.brand = brand;
		this.consumption = consumption;
		this.cubage = cubage;
		this.distance = distance;
		this.isActive = isActive;
		this.isAvailable = isAvailable;
		this.lastService = lastService;
		this.licenceNum = licenceNum;
		this.model = model;
		this.vehicleNum = vehicleNum;
		this.travelOrders = travelOrders;
	}

	public Vehicle(String brand, float consumption, float cubage, int distance, boolean isActive, boolean isAvailable,
			int lastService, String licenceNum, String model, String vehicleNum, List<TravelOrder> travelOrders) {
		this.brand = brand;
		this.consumption = consumption;
		this.cubage = cubage;
		this.distance = distance;
		this.isActive = isActive;
		this.isAvailable = isAvailable;
		this.lastService = lastService;
		this.licenceNum = licenceNum;
		this.model = model;
		this.vehicleNum = vehicleNum;
		this.travelOrders = travelOrders;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public float getConsumption() {
		return this.consumption;
	}

	public void setConsumption(float consumption) {
		this.consumption = consumption;
	}

	public float getCubage() {
		return this.cubage;
	}

	public void setCubage(float cubage) {
		this.cubage = cubage;
	}

	public int getDistance() {
		return this.distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public int getLastService() {
		return this.lastService;
	}

	public void setLastService(int lastService) {
		this.lastService = lastService;
	}

	public String getLicenceNum() {
		return this.licenceNum;
	}

	public void setLicenceNum(String licenceNum) {
		this.licenceNum = licenceNum;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehicleNum() {
		return this.vehicleNum;
	}

	public void setVehicleNum(String vehicleNum) {
		this.vehicleNum = vehicleNum;
	}

	public List<ServiceBook> getServiceBooks() {
		return this.serviceBooks;
	}

	public void setServiceBooks(List<ServiceBook> serviceBooks) {
		this.serviceBooks = serviceBooks;
	}

	public ServiceBook addServiceBook(ServiceBook serviceBook) {
		getServiceBooks().add(serviceBook);
		serviceBook.setVehicle(this);

		return serviceBook;
	}

	public ServiceBook removeServiceBook(ServiceBook serviceBook) {
		getServiceBooks().remove(serviceBook);
		serviceBook.setVehicle(null);

		return serviceBook;
	}

	public List<TravelOrder> getTravelOrders() {
		return this.travelOrders;
	}

	public void setTravelOrders(List<TravelOrder> travelOrders) {
		this.travelOrders = travelOrders;
	}

	public TravelOrder addTravelOrder(TravelOrder travelOrder) {
		getTravelOrders().add(travelOrder);
		travelOrder.setVehicle(this);

		return travelOrder;
	}

	public TravelOrder removeTravelOrder(TravelOrder travelOrder) {
		getTravelOrders().remove(travelOrder);
		travelOrder.setVehicle(null);

		return travelOrder;
	}

}