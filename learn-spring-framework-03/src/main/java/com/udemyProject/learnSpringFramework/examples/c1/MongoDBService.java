package com.udemyProject.learnSpringFramework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class MongoDBService implements DataService {

	@Override
	public int[] retreiveData() {
		System.out.println("MongoDBService called");
		return new int[] {21,55,11,33,44,66};
	}

	

}
