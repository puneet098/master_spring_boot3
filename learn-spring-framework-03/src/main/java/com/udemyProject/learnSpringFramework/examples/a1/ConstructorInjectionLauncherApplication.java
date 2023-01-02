package com.udemyProject.learnSpringFramework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
/**
 * Constructor Injection is used over here.
 * @author Lenovo
 *
 */
@Component
class YourBuinessClass02{
	
	Dependency5 dependency5;
	
	Dependency6 dependency6;
	
	
	/**
	 * @param dependency5
	 * @param dependency6
	 */
	public YourBuinessClass02(Dependency5 dependency5, Dependency6 dependency6) {
		super();
		System.out.println("Constructor Injection YourBuinessClass02");
		this.dependency5 = dependency5;
		this.dependency6 = dependency6;
	}


	public String toString() {
		return new StringBuffer().append("Using").append(dependency5)
				.append("and").append(dependency6).toString();
	}
}

@Component
class Dependency5{
	
}

@Component
class Dependency6{
	
}

@Configuration
@ComponentScan("com.udemyProject.learnSpringFramework.examples.a1")
public class ConstructorInjectionLauncherApplication {
	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(ConstructorInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBuinessClass02.class));
			
		}
	}

}
