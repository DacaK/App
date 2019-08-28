package com.pmfkm.vehicles.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pmfkm.vehicles.model.Vehicle;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

	List<Vehicle> findAllByIsAvailableTrue();
	List<Vehicle> findAllByIsAvailableFalse();
	
	@Query("SELECT v FROM Vehicle v WHERE v.distance - v.lastService > 30000 AND isActive=true")
	List<Vehicle> findAllVehiclesForService();
	
	@Query("SELECT v FROM Vehicle v WHERE v.distance > 300000 AND isActive=true")
	List<Vehicle> findAllVehiclesForDeactivation();
}
