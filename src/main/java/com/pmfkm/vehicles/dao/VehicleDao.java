package com.pmfkm.vehicles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmfkm.vehicles.model.Vehicle;

@Repository
public interface VehicleDao extends JpaRepository<Vehicle, Integer> {

}
