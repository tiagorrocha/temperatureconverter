package com.temperatureconverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.temperatureconverter.model.Temperature;

@Repository
public interface HistoryRepository extends JpaRepository<Temperature, Integer> {
	
}
