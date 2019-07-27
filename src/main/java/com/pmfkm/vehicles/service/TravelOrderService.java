package com.pmfkm.vehicles.service;

import java.util.List;
import java.util.Optional;

import com.pmfkm.vehicles.model.TravelOrder;

public interface TravelOrderService {

	public List<TravelOrder> findAll();
	public TravelOrder saveTravelOrder(TravelOrder travelOrder);
	public TravelOrder addTravelOrder(TravelOrder travelOrder);
	public Optional<TravelOrder> findById(int id);
	public TravelOrder updateTravelOrder(TravelOrder travelOrder);
	public List<TravelOrder> findAllByStatus(String status);
	
}
