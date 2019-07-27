package com.pmfkm.vehicles.service;

import java.util.List;
import java.util.Optional;

import com.pmfkm.vehicles.model.Vehicle;

public interface VehicleService {

	public List<Vehicle> findAll();
	public Vehicle addVehicle(Vehicle vehicle);
	public Vehicle save(Vehicle vehicle);
	public Optional<Vehicle> findById(int id);
	public void setAvaliableVehicle(int id);
	public void setUnavaliableVehicle(int id);
	public void deleteVehicle(int id);
	public void undoDeleteVehicle(int id);
	public List<Vehicle> findAllAvaliable();
	public List<Vehicle> findAllUnavaliable();
	public List<Vehicle> findAllVehiclesForService();
	public List<Vehicle> findAllVehiclesForDeactivation();
}
