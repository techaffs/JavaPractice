package com.learningByDoing.learn_spring_framework.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.learningByDoing.learn_spring_framework.game")
public class GamingAppLauncher {

//    @Bean
//    public GamingConsole game(){
//        var game = new PacmanGame();
//        return game;
//    } making pacman a component this bean definition is not required

//    @Bean
//    public GameRunner gameRunner(GamingConsole game){
//        var gameRunner = new GameRunner(game);
//        return gameRunner;
//    }

    public static void main(String[] args){

        try(var context = new AnnotationConfigApplicationContext
                (GamingAppLauncher.class)) {

            context.getBean(GameRunner.class).run();
        }
    }
}
