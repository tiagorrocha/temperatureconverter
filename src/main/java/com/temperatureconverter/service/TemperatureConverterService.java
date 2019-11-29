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

	public double celsiusToFahrenheit(String celsius) throws NumberFormatException {
		try {
			double c = Float.parseFloat(celsius);
			double fahrenheit = (c * 9 / 5) + 32;
			Temperature temperature = new Temperature(c, fahrenheit, TemperatureType.CELSIUSTOFAHRENHEIT);
			save(temperature);
			return fahrenheit;
		} catch (Exception e) {
			throw new NumberFormatException("Number Format Excepetion for input string: " + celsius );
		}
	}
	public double fahrenheitToCelsius(String fahrenheit) throws NumberFormatException {
		try {
			double f = Float.parseFloat(fahrenheit);
			double celsius = (f - 32) * 5 / 9;
			Temperature temperature = new Temperature(celsius, f, TemperatureType.FAHRENHEITTOCELSIUS);
			save(temperature);
			return celsius;
		} catch (Exception e) {
			throw new NumberFormatException("Number Format Excepetion for input string: " + fahrenheit);
		}
	}
}
