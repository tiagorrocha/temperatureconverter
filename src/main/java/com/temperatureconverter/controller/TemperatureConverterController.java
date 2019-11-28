package com.temperatureconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.temperatureconverter.service.TemperatureConverterService;

@RestController
public class TemperatureConverterController {

	@Autowired
	TemperatureConverterService service;

	@RequestMapping(value = "/fahrenheit", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public ResponseEntity<?> celsiusToFahrenheint(@RequestBody String celsius) {
		float fahrenheit = service.celsiusToFahrenheit(celsius);
		return ResponseEntity.ok().body(fahrenheit);
	}

	@RequestMapping(value = "/celsius", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public ResponseEntity<?> fahrenheitToCelsius(@RequestBody String fahrenheit) {
		float celsius = service.fahrenheitToCelsius(fahrenheit);
		return ResponseEntity.ok().body(celsius);
	}

}
