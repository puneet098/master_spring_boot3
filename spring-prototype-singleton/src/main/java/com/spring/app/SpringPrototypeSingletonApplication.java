package com.spring.app;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


@SpringBootApplication
public class SpringPrototypeSingletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPrototypeSingletonApplication.class, args);
		try(var context = 
				new AnnotationConfigApplicationContext
				(SpringPrototypeSingletonApplication.class)){
			/*
			 * Listing beans defined
			 */
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			
			
		}
	}

}
