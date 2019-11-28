package com.temperatureconverter.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Temperature implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Integer id;
	@ApiModelProperty(value = "Degrees in Celsius")
	private float celsius;
	@ApiModelProperty(value = "Degrees in Fahrenheit")
	private float fahrenheit;
	@ApiModelProperty(value = "Type of conversion")
	private Integer type;
	
	public Temperature() {
		
	}

	public Temperature(float celsius, float fahrenheit, TemperatureType temperatureType) {
		super();
		this.celsius = celsius;
		this.fahrenheit = fahrenheit;
		this.type = temperatureType.getCode();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getCelsius() {
		return celsius;
	}

	public void setCelsius(float celsius) {
		this.celsius = celsius;
	}

	public float getFahrenheit() {
		return fahrenheit;
	}

	public void setFahrenheit(float fahrenheit) {
		this.fahrenheit = fahrenheit;
	}

	public TemperatureType getType() {
		return TemperatureType.toEnum(type);
	}

	public void setType(TemperatureType temperatureType) {
		this.type = temperatureType.getCode();
	}
	
}	
