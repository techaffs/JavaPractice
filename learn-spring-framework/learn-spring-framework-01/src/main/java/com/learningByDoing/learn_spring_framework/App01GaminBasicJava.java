package com.learningByDoing.learn_spring_framework;

import com.learningByDoing.learn_spring_framework.game.GameRunner;
import com.learningByDoing.learn_spring_framework.game.MarioGame;
import com.learningByDoing.learn_spring_framework.game.PacmanGame;
import com.learningByDoing.learn_spring_framework.game.SuperContraGame;

public class App01GaminBasicJava {
    public static void main(String[] args){

//        var game = new MarioGame();
//        var game = new SuperContraGame();

        var game = new PacmanGame(); // 1. Object Creation
        var gameRunner = new GameRunner(game); // Injected or wired the dependency in
        // 2. Object Creation + Wiring of dependencies
        // Game is a dependency of GameRunner
        gameRunner.run();
    }
}
