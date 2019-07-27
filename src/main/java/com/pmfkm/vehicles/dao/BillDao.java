package com.pmfkm.vehicles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmfkm.vehicles.model.Bill;

@Repository
public interface BillDao extends JpaRepository<Bill, Integer> {

}
