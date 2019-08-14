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

import com.pmfkm.vehicles.model.ServiceBook;
import com.pmfkm.vehicles.service.ServiceBookService;


@CrossOrigin("http://localhost:4200")
@RestController
public class ServiceBookRestController {

	@Autowired
	private ServiceBookService serviceBookService;
	
	@PostMapping("/servicebook")
	public ServiceBook addServiceBookRecors(@RequestBody ServiceBook serviceBook) {
		return serviceBookService.save(serviceBook);
	}
	
	@GetMapping("/servicebook")
	public List<ServiceBook> getAllServiceBook() {
		return serviceBookService.findAll();
	}
	
	@GetMapping("/servicebook/{id}")
	public Optional <ServiceBook> getServiceBook(@PathVariable int id) {
		return serviceBookService.findById(id);
	}
	//Ne radi mi ova metoda
	@PutMapping("/servicebook")
	public ServiceBook updateServiceBook(@RequestBody ServiceBook serviceBook) {
		return serviceBookService.updateServiceBook(serviceBook);
	}
	
}
