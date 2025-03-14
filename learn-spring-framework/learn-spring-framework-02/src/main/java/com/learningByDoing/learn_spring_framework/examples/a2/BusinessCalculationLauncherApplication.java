package com.learningByDoing.learn_spring_framework.examples.a2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class BusinessCalculationLauncherApplication {

    public static void main(String[] args){

        try(var context = new AnnotationConfigApplicationContext
                (BusinessCalculationLauncherApplication.class)) {

            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
