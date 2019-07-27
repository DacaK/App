package com.pmfkm.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmfkm.vehicles.model.Bill;
import com.pmfkm.vehicles.service.BillService;

@RestController
@RequestMapping(path="/bills", produces="application/json")
public class BillRestController {
	
	@Autowired
	private BillService billService;

	@GetMapping("/bills")
	public List<Bill> allBils(){
		return billService.findAll();
	}
	
	@PostMapping("/bill")
	public Bill save(Bill bill) {
		return billService.save(bill);
	}
	
	@PutMapping("/bill")
	public Bill updateBill(Bill bill) {
		return billService.updateBill(bill);
	}
}
