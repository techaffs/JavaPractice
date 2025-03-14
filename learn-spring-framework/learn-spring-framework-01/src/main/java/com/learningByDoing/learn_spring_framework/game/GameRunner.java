package com.learningByDoing.learn_spring_framework.game;

public class GameRunner {

//    MarioGame game;
    private GamingConsole game;
    public GameRunner(GamingConsole game) {
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
