package com.pmfkm.vehicles.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the TRAVEL_STATUS database table.
 * 
 */
@Entity
@Table(name="TRAVEL_STATUS")
@NamedQuery(name="TravelStatus.findAll", query="SELECT t FROM TravelStatus t")
public class TravelStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	//bi-directional many-to-one association to TravelOrder
	@OneToMany(mappedBy="travelStatus")
	@JsonIgnore
	private List<TravelOrder> travelOrders;
	
	public TravelStatus() {
	};
	public TravelStatus(long id, String name, List<TravelOrder> travelOrders) { 
		this.id = id;
		this.name = name;
		this.travelOrders = travelOrders;
	} 

	public TravelStatus(String name, List<TravelOrder> travelOrders) { 
		this.name = name;
		this.travelOrders = travelOrders;
	} 

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TravelOrder> getTravelOrders() {
		return this.travelOrders;
	}

	public void setTravelOrders(List<TravelOrder> travelOrders) {
		this.travelOrders = travelOrders;
	}

	public TravelOrder addTravelOrder(TravelOrder travelOrder) {
		getTravelOrders().add(travelOrder);
		travelOrder.setTravelStatus(this);

		return travelOrder;
	}

	public TravelOrder removeTravelOrder(TravelOrder travelOrder) {
		getTravelOrders().remove(travelOrder);
		travelOrder.setTravelStatus(null);

		return travelOrder;
	}

}