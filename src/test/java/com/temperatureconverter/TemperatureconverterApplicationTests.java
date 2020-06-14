package com.temperatureconverter;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.temperatureconverter.model.Temperature;
import com.temperatureconverter.model.TemperatureType;
import com.temperatureconverter.repository.HistoryRepository;
import com.temperatureconverter.repository.TemperatureConverterRepository;
import com.temperatureconverter.service.HistoryService;
import com.temperatureconverter.service.TemperatureConverterService;
import com.temperatureconverter.service.exception.NumberFormatException;

@SpringBootTest
class TemperatureconverterApplicationTests {
	
	@MockBean
	TemperatureConverterRepository temperatureConverterRepository;
	
	@Autowired
	TemperatureConverterService temperatureConverterService;
	
	@MockBean
	HistoryRepository historyRepository;
	
	@Autowired
	HistoryService historyService;
	
	@Test
	public void getAllTest() {
		when(historyRepository.findAll()).thenReturn(Stream
		.of(new Temperature(5.0,41.15,TemperatureType.CELSIUSTOFAHRENHEIT), 
		new Temperature(50,10,TemperatureType.FAHRENHEITTOCELSIUS)).collect(Collectors.toList()));
		assertEquals(2, historyService.getAll().size());
	}
	@Test
	public void saveTemperatureTest() {
		Temperature temperature = new Temperature(10.12,50.35,TemperatureType.CELSIUSTOFAHRENHEIT);
		when(temperatureConverterRepository.save(temperature)).thenReturn(temperature);
		assertEquals(temperature, temperatureConverterService.save(temperature));
	}
	@Test
	public void celsiusToFahrenheitTest() {
		String celsius = "10.0";
		double fahrenheit = 50;
		when(temperatureConverterService.celsiusToFahrenheit(celsius)).thenReturn(fahrenheit);
		assertEquals(fahrenheit,temperatureConverterService.celsiusToFahrenheit(celsius));
	}
	@Test
	public void fahrenheitToCelsiusTest() {
		String fahrenheit = "41.0";
		double celsius = 5;
		when(temperatureConverterService.fahrenheitToCelsius(fahrenheit)).thenReturn(celsius);
		assertEquals(celsius, temperatureConverterService.fahrenheitToCelsius(fahrenheit));
	}
	@Test
	public void throwNumberFormatExceptionTest() {
		String celsius = "test";
		Exception exception  = assertThrows(NumberFormatException.class, () -> {
			temperatureConverterService.celsiusToFahrenheit(celsius);
		});
		String expectedMessage = "Number Format Excepetion for input string: " + celsius;
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.contains(expectedMessage));
	}
}
