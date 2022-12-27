package com.udemyProject.learnSpringFramework;

import com.udemyProject.learnSpringFramework.game.GameRunner;
import com.udemyProject.learnSpringFramework.game.MarioGame;
import com.udemyProject.learnSpringFramework.game.PacManGame;
import com.udemyProject.learnSpringFramework.game.SuperContraGame;

public class App01AppGamingBasicJava {

	public static void main(String[] args) {
		
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		var game = new PacManGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}
