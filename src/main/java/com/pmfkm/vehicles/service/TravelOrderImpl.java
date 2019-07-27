package com.pmfkm.vehicles.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmfkm.vehicles.dao.TravelOrderDao;
import com.pmfkm.vehicles.dao.VehicleDao;
import com.pmfkm.vehicles.model.TravelOrder;
import com.pmfkm.vehicles.model.TravelStatus;
import com.pmfkm.vehicles.model.Vehicle;

@Service
public class TravelOrderImpl implements TravelOrderService{

	@Autowired
	private TravelOrderDao travelOrderDao;
	
	@Autowired
	private VehicleDao vehicleDao;

	@Override
	public List<TravelOrder> findAll() {
		return travelOrderDao.findAll();
	}
//Proveriti sta ova metoda zaista radi
	@Override
	public TravelOrder saveTravelOrder(TravelOrder travelOrder) {
		return travelOrderDao.save(travelOrder);
	}

	@Override
	public TravelOrder addTravelOrder(TravelOrder travelOrder) {
		travelOrder.setCreatedAt(new Timestamp(System.currentTimeMillis()));
		TravelStatus travelStatus = new TravelStatus();
		travelStatus.setId(1);
		travelOrder.setTravelStatus(travelStatus);
		return this.travelOrderDao.save(travelOrder);
	}

	@Override
	public Optional<TravelOrder> findById(int id) {
		return travelOrderDao.findById(id);
	}

	@Override
	public TravelOrder updateTravelOrder(TravelOrder travelOrder) {
		int status = (int) travelOrder.getTravelStatus().getId();
		
		if(status == 2 ) {
			Vehicle vehicle = travelOrder.getVehicle();
			vehicle.setIsAvailable(false);
			travelOrder.setVehicle(vehicle);
			vehicleDao.save(vehicle);
			travelOrderDao.save(travelOrder);
		}else if (status == 4 ) {
			Vehicle vehicle = travelOrder.getVehicle();
			vehicle.setIsAvailable(true);
			vehicle.setDistance(vehicle.getDistance() + travelOrder.getActDistance());
			travelOrder.setVehicle(vehicle);
			vehicleDao.save(vehicle);
			travelOrderDao.save(travelOrder);
		}else {
			travelOrderDao.save(travelOrder);
		}
		return travelOrder;
	}

	@Override
	public List<TravelOrder> findAllByStatus(String status) {
		List<TravelOrder> travelOrders = travelOrderDao.findAll();
		List<TravelOrder> travelOrdersByStatus = new ArrayList<TravelOrder>();
		
		for (TravelOrder travelOrder : travelOrders) {
			if(travelOrder.getTravelStatus().getName().equals(status)) {
				travelOrdersByStatus.add(travelOrder);
			}
		}
		return travelOrdersByStatus;
	}

	
}
