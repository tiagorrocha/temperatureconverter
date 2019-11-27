package com.temperatureconverter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.temperatureconverter.model.Temperature;
import com.temperatureconverter.repository.HistoryRepository;

@Service
public class HistoryService {
	
	@Autowired
	HistoryRepository repository;
	
	public List<Temperature> getAll() {
		return repository.findAll();
	}
}
