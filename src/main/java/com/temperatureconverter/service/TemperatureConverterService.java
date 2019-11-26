package com.temperatureconverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temperatureconverter.model.Temperature;
import com.temperatureconverter.model.TemperatureType;
import com.temperatureconverter.repository.TemperatureConverterRepository;

@Service
public class TemperatureConverterService {
	
	@Autowired
	TemperatureConverterRepository repository;
	
	public Temperature save(Temperature temperature) {
		return repository.save(temperature);
	}
	
	public float celsiusToFahrenheit(float celsius) {
		float fahrenheit = (celsius * 9/5 ) + 32;
		Temperature temperature = new Temperature(celsius,fahrenheit,TemperatureType.CELSIUSTOFAHRENHEITE);
		save(temperature);
		return fahrenheit;
	}
	
	public float fahrenheitToCelsius(float fahrenheit) {
		float celsius = (fahrenheit - 32) * 5/9;
		Temperature temperature = new Temperature(celsius,fahrenheit,TemperatureType.FAHRENHEITTOCELSIUS);
		save(temperature);
		return celsius;
	}
	
}
