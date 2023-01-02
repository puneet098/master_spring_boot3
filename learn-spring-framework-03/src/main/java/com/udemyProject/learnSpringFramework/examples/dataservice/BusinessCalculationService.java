package com.udemyProject.learnSpringFramework.examples.dataservice;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessCalculationService {
	
	@Autowired
	private DataService dataService;
	
	public int findMax() {
		return Arrays.stream(dataService.retreiveData()).max().orElse(0);
	}
}
