package com.pmfkm.vehicles.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pmfkm.vehicles.model.TravelOrder;

@Repository
public interface TravelOrderDao extends JpaRepository<TravelOrder, Integer>{

	@Query("SELECT t FROM TravelOrder t INNER JOIN t.travelStatus ts WHERE name = :status")
	List<TravelOrder> findAllByStatus(@Param("status") String status);
}
