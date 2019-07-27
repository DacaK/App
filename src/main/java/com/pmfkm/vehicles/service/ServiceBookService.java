package com.pmfkm.vehicles.service;

import java.util.List;
import java.util.Optional;

import com.pmfkm.vehicles.model.ServiceBook;

public interface ServiceBookService {

	public List<ServiceBook> findAll();
	public Optional<ServiceBook> findById(int id);
	public ServiceBook save(ServiceBook serviceBook);
	public ServiceBook updateServiceBook(ServiceBook serviceBook);
}
