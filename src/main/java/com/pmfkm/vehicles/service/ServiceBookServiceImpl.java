package com.pmfkm.vehicles.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmfkm.vehicles.dao.ServiceBookDao;
import com.pmfkm.vehicles.model.ServiceBook;

@Service
public class ServiceBookServiceImpl implements ServiceBookService {
	
	@Autowired
	private ServiceBookDao serviceBookDao;

	@Override
	public List<ServiceBook> findAll() {
		return serviceBookDao.findAll();
	}

	@Override
	public Optional<ServiceBook> findById(int id) {
		return serviceBookDao.findById(id);
	}

	@Override
	public ServiceBook updateServiceBook(ServiceBook serviceBook) {
		Optional<ServiceBook> serviceBookById = serviceBookDao.findById((int) serviceBook.getId());
		return serviceBookDao.save(serviceBookById.get());
	}

	@Override
	public ServiceBook save(ServiceBook serviceBook) {
		return serviceBookDao.save(serviceBook);
	}
	
	
}
