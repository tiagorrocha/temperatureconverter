package com.temperatureconverter.model;

public enum TemperatureType {

	CELSIUSTOFAHRENHEITE(1, "Celsius to fahrenheit"), 
	FAHRENHEITTOCELSIUS(2, "Fahrenheit to celsius");

	private int code;
	private String description;

	private TemperatureType(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static TemperatureType toEnum(Integer code) {

		if (code == null)
			return null;

		for (TemperatureType x : TemperatureType.values()) {
			if (code.equals(x.getCode()))
				return x;
		}

		throw new IllegalArgumentException("Invalid id: " + code);
	}

}
