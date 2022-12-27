package com.udemyProject.learnSpringFramework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.udemyProject.learnSpringFramework.game.GameRunner;
import com.udemyProject.learnSpringFramework.game.GamingConsole;

public class App03GamingSpringBeans {

	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(GamingConfiguration.class)){
			context.getBean(GamingConsole.class).up();;
			context.getBean(GameRunner.class).run();
		}
	}

}
