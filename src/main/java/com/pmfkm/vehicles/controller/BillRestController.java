package com.pmfkm.vehicles.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pmfkm.vehicles.model.Bill;
import com.pmfkm.vehicles.service.BillService;

@CrossOrigin("http://localhost:4200")
@RestController
public class BillRestController {
	
	@Autowired
	private BillService billService;

	@GetMapping("/bills")
	public List<Bill> allBils(){
		return billService.findAll();
	}
	
	@PostMapping("/bill")
	public Bill save(@Valid @RequestBody Bill bill) {
		return billService.save(bill);
	}
	
	@PutMapping("/bill")
	public Bill updateBill(@Valid @RequestBody Bill bill) {
		return billService.updateBill(bill);
	}
} 