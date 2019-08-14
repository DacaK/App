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

import com.pmfkm.vehicles.model.TravelOrder;
import com.pmfkm.vehicles.service.TravelOrderService;
@CrossOrigin("http://localhost:4200")
@RestController
public class TravelOrderRestController {

	@Autowired
	private TravelOrderService travelOrderService;
	
	@GetMapping("/travelorder")
	public List<TravelOrder> allTraverOrders(){
		return travelOrderService.findAll();
	}
	
	@PostMapping("/travelorder")
	public TravelOrder addTravelOrder(@RequestBody TravelOrder travelOrder) {
		return travelOrderService.addTravelOrder(travelOrder);
	}
	
	@GetMapping("/travelorder/{id}")
	public Optional<TravelOrder> getTravelOrder(@PathVariable("id") int id){
		return travelOrderService.findById(id);
	}
	
	@PutMapping("/travelorder")
	public TravelOrder updateTravelOrder(@RequestBody TravelOrder travelOrder) {
		return travelOrderService.updateTravelOrder(travelOrder);
	}
		
	@GetMapping("/travelorders/{status}")
	public List<TravelOrder> travelOrdersByStatus(@PathVariable("status") String status){
		return travelOrderService.findAllByStatus(status);
	}
}
