package com.pmfkm.vehicles.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmfkm.vehicles.dao.VehicleDao;
import com.pmfkm.vehicles.model.ServiceBook;
import com.pmfkm.vehicles.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	@Override
	public List<Vehicle> findAll() {
		return vehicleDao.findAll();
	}
	
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		vehicle.setIsActive(true);
		vehicle.setIsAvailable(true);
		return this.vehicleDao.save(vehicle);
	}
	
	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}

	@Override
	public Optional<Vehicle> findById(int id) {
		return vehicleDao.findById(id);
	}

	@Override
	public void setAvaliableVehicle(int id) {
		Optional<Vehicle> vehicle = vehicleDao.findById((int) id);
		vehicle.get().setIsAvailable(true);
		vehicleDao.save(vehicle.get());
	}

	@Override
	public void setUnavaliableVehicle(int id) {
		Optional<Vehicle> vehicle = vehicleDao.findById((int)id);
		vehicle.get().setIsAvailable(false);
		vehicleDao.save(vehicle.get());
	}

	@Override
	public void deleteVehicle(int id) {
		Optional<Vehicle> vehicle = vehicleDao.findById(id);
		vehicle.get().setIsActive(false);
		vehicle.get().setIsAvailable(false);
		vehicleDao.save(vehicle.get());
	}

	@Override
	public void undoDeleteVehicle(int id) {
		Optional<Vehicle> vehicle = vehicleDao.findById(id);
		vehicle.get().setIsActive(true);
		vehicle.get().setIsAvailable(true);
		vehicleDao.save(vehicle.get());
	}

	@Override
	public List<Vehicle> findAllAvaliable() {
		List<Vehicle> vehicles = vehicleDao.findAll();
		List<Vehicle> allAvaliableVehicles = new ArrayList<>();
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getIsAvailable() == true) {
				allAvaliableVehicles.add(vehicle);
			}
		}
		return allAvaliableVehicles;
	}

	@Override
	public List<Vehicle> findAllUnavaliable() {
		List<Vehicle> vehicles = vehicleDao.findAll();
		List<Vehicle> allUnavaliableVehicles = new ArrayList<>();
		
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getIsAvailable() == false) {
				allUnavaliableVehicles.add(vehicle);
			}
		}
		return allUnavaliableVehicles;
	}

	@Override
	public List<Vehicle> findAllVehiclesForService() {
		List<Vehicle> vehicles = vehicleDao.findAll();
		List<Vehicle> vehiclesForService = new ArrayList<>();
		for (Vehicle vehicle : vehicles) {
			if((vehicle.getDistance() - vehicle.getLastService()) > 30000 && vehicle.getIsActive() == true) {
				vehiclesForService.add(vehicle);
			}
		}
		return vehiclesForService;
	}

	@Override
	public List<Vehicle> findAllVehiclesForDeactivation() {
		List<Vehicle> vehicles = vehicleDao.findAll();
		List<Vehicle> vehiclesForDeactivating = new ArrayList<>();
		
		for (Vehicle vehicle : vehicles) {
			if(vehicle.getDistance() >= 300000 && vehicle.getIsActive() == true) {
				vehiclesForDeactivating.add(vehicle);
			}
		}
		return vehiclesForDeactivating;
	}

	@Override
	public List<ServiceBook> getAllServiceBookByIdVehicle(int id) {
		Optional<Vehicle> vehicle = vehicleDao.findById(id);
		return vehicle.get().getServiceBooks();
	}
	
	
}
