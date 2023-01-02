package com.udemyProject.learnSpringFramework.examples.lazyinit;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
}

@Component
@Lazy
class ClassB{
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		//logic
		System.out.println("Some initalization Logic ..");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
}

@Configuration
@ComponentScan
public class LazyInitalizationContextLauncherApplication {
	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(LazyInitalizationContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			context.getBean(ClassB.class).doSomething();
			
						
		}
	}

}
