package com.temperatureconverter.service.exception;

public class NumberFormatException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public NumberFormatException (String msg) {
		super(msg);
	}
	public NumberFormatException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
