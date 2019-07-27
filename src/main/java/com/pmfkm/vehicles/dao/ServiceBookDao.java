package com.pmfkm.vehicles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmfkm.vehicles.model.ServiceBook;

@Repository
public interface ServiceBookDao extends JpaRepository<ServiceBook, Integer> {

}
