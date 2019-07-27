package com.pmfkm.vehicles.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmfkm.vehicles.model.Vehicle;
import com.pmfkm.vehicles.service.VehicleService;

@CrossOrigin("http://localhost:4200")
@RestController
public class VehicleRestController {
	
	@Autowired
	private VehicleService vehicleService;
	
	@GetMapping("/vehicles")
	public List<Vehicle> findAll(){
		return vehicleService.findAll();
	}
	
	@PostMapping("/vehicle")
	public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.addVehicle(vehicle);
	}
	@PutMapping("/vehicle")
	public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
		Optional <Vehicle> vehicleById = vehicleService.findById(vehicle.getId());
		return vehicleService.save(vehicleById.get());
	}
	
	@GetMapping("/vehicle/{id}")
	public Optional<Vehicle> findById(@PathVariable("id") int id){
		return vehicleService.findById(id);
	}
	
	@PutMapping("/unavaliable/{id}")
	public void setUnavaliableVehicle(@PathVariable("id") int id) {
		vehicleService.setUnavaliableVehicle(id);
	}
	
	@PutMapping("/avaliable/{id}")
	public void setAvaliableVehicle(@PathVariable("id") int id) {
		vehicleService.setAvaliableVehicle(id);
	}
	
	@PutMapping("/delete/{id}")
	public void deleteVehicle(@PathVariable("id") int id) {
		vehicleService.deleteVehicle(id);
	}
	
	@PutMapping("/undodelete/{id}")
	public void undoDeleteVehicle(@PathVariable("id") int id) {
		vehicleService.undoDeleteVehicle(id);
	}
	
	@GetMapping("/allavaliable")
	public List<Vehicle> findAllAvaliable(){
		return vehicleService.findAllAvaliable();
	}
	
	@GetMapping("/allunavaliable")
	public List<Vehicle> findAllUnavaliable(){
		return vehicleService.findAllUnavaliable();
	}
	
	@GetMapping("/forservice")
	public List<Vehicle> allVehiclesForService(){
		return vehicleService.findAllVehiclesForService();
	}
	
	@GetMapping("/fordeactivation")
	public List<Vehicle> allVehiclesForDeactivation(){
		return vehicleService.findAllVehiclesForDeactivation();
	}
	
}
