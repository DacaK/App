package com.pmfkm.vehicles.model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the SERVICE_BOOK database table.
 * 
 */
@Entity
@Table(name="SERVICE_BOOK")
@NamedQuery(name="ServiceBook.findAll", query="SELECT s FROM ServiceBook s")
public class ServiceBook implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name="COMPANY_NAME")
	private String companyName;

	@Temporal(TemporalType.DATE)
	@Column(name="REPAIR_DATE")
	private Date repairDate;

	@Column(name="REPAIR_KILOMETERS")
	private int repairKilometers;

	@Column(name="SERVICE_DESCRIPTION")
	private String serviceDescription;

	//bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

	public ServiceBook() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getRepairDate() {
		return this.repairDate;
	}

	public void setRepairDate(Date repairDate) {
		this.repairDate = repairDate;
	}

	public int getRepairKilometers() {
		return this.repairKilometers;
	}

	public void setRepairKilometers(int repairKilometers) {
		this.repairKilometers = repairKilometers;
	}

	public String getServiceDescription() {
		return this.serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Vehicle getVehicle() {
		return this.vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}