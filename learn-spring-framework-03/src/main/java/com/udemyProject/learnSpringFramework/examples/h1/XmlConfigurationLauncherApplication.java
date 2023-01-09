package com.udemyProject.learnSpringFramework.examples.h1;

import java.util.Arrays;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.udemyProject.learnSpringFramework.game.GameRunner;

public class XmlConfigurationLauncherApplication {
	
	public static void main(String[] args) {
		try(var context = 
				new ClassPathXmlApplicationContext
				("contextConfiguration.xml")){
			Arrays.stream(context.getBeanDefinitionNames())
			.forEach(System.out::println);
			
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			/*
			 * System.out.println(context.getBean("game"));
			 * System.out.println(context.getBean("gameRunner"));
			 */
			context.getBean(GameRunner.class).run();
		}
	}

}
