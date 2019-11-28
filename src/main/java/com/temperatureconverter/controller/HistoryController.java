package com.temperatureconverter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.temperatureconverter.model.Temperature;
import com.temperatureconverter.service.HistoryService;

@RestController
@RequestMapping(value="/history")
public class HistoryController {
	
	@Autowired
	HistoryService service;
	
	@RequestMapping(method = RequestMethod.GET, produces="application/json")
	public List<Temperature> getAll(){
		return service.getAll();
	}
}
