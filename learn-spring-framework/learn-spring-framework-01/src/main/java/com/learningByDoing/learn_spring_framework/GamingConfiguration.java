package com.learningByDoing.learn_spring_framework;

import com.learningByDoing.learn_spring_framework.game.GameRunner;
import com.learningByDoing.learn_spring_framework.game.GamingConsole;
import com.learningByDoing.learn_spring_framework.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
}
