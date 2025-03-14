package com.learningByDoing.learn_spring_framework;

import com.learningByDoing.learn_spring_framework.game.GameRunner;
import com.learningByDoing.learn_spring_framework.game.GamingConsole;
import com.learningByDoing.learn_spring_framework.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GaminSpringBeans {
    public static void main(String[] args){

        try(var context = new AnnotationConfigApplicationContext
                (GamingConfiguration.class)) {

            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }

    }
}
