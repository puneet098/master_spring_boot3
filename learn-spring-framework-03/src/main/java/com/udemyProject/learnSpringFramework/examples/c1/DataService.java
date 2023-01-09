package com.udemyProject.learnSpringFramework.examples.c1;

import org.springframework.stereotype.Repository;

@Repository
public interface DataService {
	public int[] retreiveData();
}
