package com.learningByDoing.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole{

    public void up(){
        System.out.println("Go up");
    }

    public void down(){
        System.out.println("Go down");
    }

    public void left(){
        System.out.println("Go left");
    }

    public void right(){
        System.out.println("Go right");
    }
}
