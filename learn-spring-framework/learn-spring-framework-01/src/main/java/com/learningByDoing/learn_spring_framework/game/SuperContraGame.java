package com.learningByDoing.learn_spring_framework.game;

public class SuperContraGame implements GamingConsole{

    public void up(){
        System.out.println("up");
    }

    public void down(){
        System.out.println("Sit Down");
    }

    public void left(){
        System.out.println("Go back");
    }

    public void right(){
        System.out.println("Shoot");
    }
}
