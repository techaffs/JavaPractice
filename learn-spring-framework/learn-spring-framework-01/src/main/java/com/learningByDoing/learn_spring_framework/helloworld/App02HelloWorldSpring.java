package com.learningByDoing.learn_spring_framework.helloworld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App02HelloWorldSpring {
    public static void main(String[] args){
        // 1. Launch a Spring Context
        try(var context =
                    new AnnotationConfigApplicationContext
                            (HelloWorldConfiguration.class)){

        // 2. Configure the things that we want Spring to manage - @Configuration
        // Hello HelloWorldConfiguration - @Configuration
        // name - @Bean

        // 3. Retrieving Beans managed by Spring
            System.out.println(context.getBean("name"));
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("address2")); // by Name of the Bean
            System.out.println(context.getBean(Address.class)); // by Type of the Bean
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3parameters"));

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }
    }
}
