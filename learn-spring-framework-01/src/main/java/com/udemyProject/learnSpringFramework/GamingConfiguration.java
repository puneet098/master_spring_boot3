package com.udemyProject.learnSpringFramework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemyProject.learnSpringFramework.game.GameRunner;
import com.udemyProject.learnSpringFramework.game.GamingConsole;
import com.udemyProject.learnSpringFramework.game.PacManGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacManGame();
		return game;
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}
}
