package com.udemyProject.learnSpringFramework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

//JDK 16 feature
record Person( String name, int age,Address address){};

record Address( String firstLine, String city) {};
@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Puneet";
	}
	
	@Bean
	public int age() {
		return 42;
	}
	/*
	 * Injecting by method call
	 */
	@Bean(name="person2")
	public Person person2MethodCall() {
		var person = new Person(name(),age(), address01());
		return person;
	}
	/*
	 * Injecting through parameters
	 */
	@Bean
	@Primary
	public Person person3Parameters(String name, int age,@Qualifier("mumQualifier")Address address) {
		return new Person(name, age,address);
	}
	
	@Bean()
	@Scope("prototype")
	public Person person() {
		var person = new Person("Vineet",39,address());
		return person;
	}
	
	@Bean(name="blrPata")
	@Primary
	public Address address() {
		var address = new Address("J.P. Nagar","Bangalore");
		return address;
	}
	
	@Bean(name="mumPata")
	@Qualifier("mumQualifier")
	public Address address01() {
		var address = new Address("Green Wrold","Airoli");
		return address;
	}
}
