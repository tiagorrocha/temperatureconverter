package com.temperatureconverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temperatureconverter.model.Temperature;
import com.temperatureconverter.model.TemperatureType;
import com.temperatureconverter.repository.TemperatureConverterRepository;
import com.temperatureconverter.service.exception.NumberFormatException;

@Service
public class TemperatureConverterService {

	@Autowired
	TemperatureConverterRepository repository;

	public Temperature save(Temperature temperature) {
		return repository.save(temperature);
	}

	public float celsiusToFahrenheit(String celsius) throws NumberFormatException {
		try {
			float c = Float.parseFloat(celsius);
			float fahrenheit = (c * 9 / 5) + 32;
			Temperature temperature = new Temperature(c, fahrenheit, TemperatureType.CELSIUSTOFAHRENHEIT);
			save(temperature);
			return fahrenheit;
		} catch (Exception e) {
			throw new NumberFormatException("Number Format Excepetion for input string: " + celsius );
		}
	}
	public float fahrenheitToCelsius(String fahrenheit) throws NumberFormatException {
		try {
			float f = Float.parseFloat(fahrenheit);
			float celsius = (f - 32) * 5 / 9;
			Temperature temperature = new Temperature(celsius, f, TemperatureType.FAHRENHEITTOCELSIUS);
			save(temperature);
			return celsius;
		} catch (Exception e) {
			throw new NumberFormatException("Number Format Excepetion for input string: " + fahrenheit);
		}
	}
}
