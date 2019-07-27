package com.pmfkm.vehicles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmfkm.vehicles.model.TravelOrder;

@Repository
public interface TravelOrderDao extends JpaRepository<TravelOrder, Integer>{

}
