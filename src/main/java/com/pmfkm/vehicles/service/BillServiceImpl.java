package com.pmfkm.vehicles.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pmfkm.vehicles.dao.BillDao;
import com.pmfkm.vehicles.model.Bill;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillDao billDao;
	
	@Override
	public List<Bill> findAll() {
		return billDao.findAll();
	}

	@Override
	public Bill save(Bill bill) {
		return billDao.save(bill);
	}

	@Override
	public Bill updateBill(Bill bill) {
		Optional<Bill> theBill = billDao.findById((int) bill.getId());
		return billDao.save(theBill.get());
	}
}
