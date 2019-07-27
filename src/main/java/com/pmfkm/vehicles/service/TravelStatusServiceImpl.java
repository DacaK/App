package com.pmfkm.vehicles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmfkm.vehicles.dao.TravelStatusDao;
import com.pmfkm.vehicles.model.TravelStatus;

@Service
public class TravelStatusServiceImpl implements TravelStatusService {

	@Autowired
	private TravelStatusDao travelStatusDao;

	@Override
	public List<TravelStatus> findAll() {
		return travelStatusDao.findAll();
	}
}
