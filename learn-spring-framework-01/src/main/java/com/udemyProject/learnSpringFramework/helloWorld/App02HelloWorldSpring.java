package com.udemyProject.learnSpringFramework.helloWorld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		//Launch a Spring Context
		//Configure things that Spring Manages - @Configuration
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			System.out.println(context.getBean("person"));
			
			System.out.println(context.getBean("person2"));
			
			System.out.println(context.getBean("blrPata"));
			
			System.out.println(context.getBean("person3Parameters"));
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(Address.class));
			
			System.out.println(context.getBean(Person.class));
		}
		
		
	}

}
