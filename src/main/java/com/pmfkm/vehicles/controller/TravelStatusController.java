package com.pmfkm.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmfkm.vehicles.model.TravelStatus;
import com.pmfkm.vehicles.service.TravelStatusService;

@CrossOrigin("http://localhost:4200")
@RestController
public class TravelStatusController {
	
	@Autowired
	TravelStatusService travelStatusService;
	
	@GetMapping("/travelStatuses")
	public List<TravelStatus> findAllTravelStatus(){
		return this.travelStatusService.findAll();
	}
	
	

}
