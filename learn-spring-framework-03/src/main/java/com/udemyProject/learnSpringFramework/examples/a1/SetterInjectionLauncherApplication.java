package com.udemyProject.learnSpringFramework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
/**
 * Setter Injection is used over here.
 * @author Lenovo
 *
 */
@Component
class YourBuinessClass01{
	
	Dependency3 dependency3;
	
	Dependency4 dependency4;
	@Autowired
	public void setDependency3(Dependency3 dependency3) {
		System.out.println("Setter Injection -> Dependency3");
		this.dependency3 = dependency3;
	}
	@Autowired
	public void setDependency4(Dependency4 dependency4) {
		System.out.println("Setter Injection -> dependency4");
		this.dependency4 = dependency4;
	}

	public String toString() {
		return new StringBuffer().append("Using").append(dependency3)
				.append("and").append(dependency4).toString();
	}
}

@Component
class Dependency3{
	
}

@Component
class Dependency4{
	
}

@Configuration
@ComponentScan("com.udemyProject.learnSpringFramework.examples.a1")
public class SetterInjectionLauncherApplication {
	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(SetterInjectionLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBuinessClass01.class));
			
		}
	}

}
