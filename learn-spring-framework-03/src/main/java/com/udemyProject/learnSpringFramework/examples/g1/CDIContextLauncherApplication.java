package com.udemyProject.learnSpringFramework.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext
				(CDIContextLauncherApplication.class)){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean(BusinessService.class)
					.getDataservice());
		}
	}

}

//@Component
@Named
class BusinessService{
	private DataService dataservice;
	
	public DataService getDataservice() {
		return dataservice;
	}
	
	//@Autowired
	@Inject
	public void setDataservice(DataService dataservice) {
		System.out.println(" Setter Injection will be performed.");
		this.dataservice = dataservice;
	}
	
	
}

//@Component
@Named
class DataService{
	
}
