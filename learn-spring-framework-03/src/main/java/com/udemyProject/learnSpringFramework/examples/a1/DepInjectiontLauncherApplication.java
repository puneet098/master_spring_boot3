package com.udemyProject.learnSpringFramework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
/**
 * Field Injection is used over here.
 * @author Lenovo
 *
 */
@Component
class YourBuinessClass{
	@Autowired
	Dependency1 dependency1;
	@Autowired
	Dependency2 dependency2;
	
	public String toString() {
		return new StringBuffer().append("Using").append(dependency1)
				.append("and").append(dependency2).toString();
	}
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan("com.udemyProject.learnSpringFramework.examples.a1")
public class DepInjectiontLauncherApplication {
	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(DepInjectiontLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBuinessClass.class));
			
		}
	}

}
