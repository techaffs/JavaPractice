package com.learningByDoing.learn_spring_framework.examples.a3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}

@Component
@Lazy
class ClassB{
    private ClassA classA;

    public ClassB(ClassA classA){
        System.out.println("Some Initialization logic goes here");
        this.classA = classA;
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args){

        try(var context = new AnnotationConfigApplicationContext
                (LazyInitializationLauncherApplication.class)) {
            System.out.println("Initialization of context is done");

            System.out.println(context.getBean(ClassB.class));
//            Arrays.stream(context.getBeanDefinitionNames())
//                    .forEach(System.out::println);
        }
    }
}
