package com.temperatureconverter.controller.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.temperatureconverter.service.exception.NumberFormatException;
@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<StandardError> numberFormat(NumberFormatException e, HttpServletRequest request){
		
		StandardError err = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}
}
