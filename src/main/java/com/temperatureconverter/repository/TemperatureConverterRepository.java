package com.temperatureconverter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.temperatureconverter.model.Temperature;

public interface TemperatureConverterRepository extends JpaRepository<Temperature, Integer> {

}
