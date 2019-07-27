package com.pmfkm.vehicles.service;

import java.util.List;

import com.pmfkm.vehicles.model.Bill;

public interface BillService {

	public List<Bill> findAll();
	public Bill save(Bill bill);
	public Bill updateBill(Bill bill);
}
