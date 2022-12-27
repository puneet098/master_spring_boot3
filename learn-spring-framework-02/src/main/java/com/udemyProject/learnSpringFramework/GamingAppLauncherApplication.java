package com.udemyProject.learnSpringFramework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.udemyProject.learnSpringFramework.game.GameRunner;
import com.udemyProject.learnSpringFramework.game.GamingConsole;
import com.udemyProject.learnSpringFramework.game.PacManGame;

@Configuration
@ComponentScan("com.udemyProject.learnSpringFramework.game")
public class GamingAppLauncherApplication {
	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
				(GamingAppLauncherApplication.class)){
			context.getBean(GamingConsole.class).up();;
			context.getBean(GameRunner.class).run();
		}
	}

}
