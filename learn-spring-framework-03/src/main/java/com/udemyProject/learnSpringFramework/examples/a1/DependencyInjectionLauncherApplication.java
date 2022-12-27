package com.udemyProject.learnSpringFramework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.udemyProject.learnSpringFramework.examples.a1")
public class DependencyInjectionLauncherApplication {
	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(DependencyInjectionLauncherApplication.class)){
			
		}
	}

}
