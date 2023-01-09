package com.udemyProject.learnSpringFramework.examples.c1;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlDataService implements DataService {

	@Override
	public int[] retreiveData() {
		System.out.println("MySqlDataService called");
		return  new int[] {21,55,11,33,44,66};
	}

}
