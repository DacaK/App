package com.pmfkm.vehicles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmfkm.vehicles.model.TravelStatus;

@Repository
public interface TravelStatusDao extends JpaRepository<TravelStatus, Integer>{

}
