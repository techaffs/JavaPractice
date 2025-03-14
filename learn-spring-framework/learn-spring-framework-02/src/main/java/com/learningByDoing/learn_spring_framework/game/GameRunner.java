package com.learningByDoing.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

//    MarioGame game;
    private GamingConsole game;
    public GameRunner(@Qualifier("SuperContraQualifier") GamingConsole game) { // Constructor injection
        this.game = game;
    }

    public void run() {
        System.out.println("running game: " + game);
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
