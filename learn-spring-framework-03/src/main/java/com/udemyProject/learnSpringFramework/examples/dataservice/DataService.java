package com.udemyProject.learnSpringFramework.examples.dataservice;

import org.springframework.stereotype.Repository;

@Repository
public interface DataService {
	public int[] retreiveData();
}
