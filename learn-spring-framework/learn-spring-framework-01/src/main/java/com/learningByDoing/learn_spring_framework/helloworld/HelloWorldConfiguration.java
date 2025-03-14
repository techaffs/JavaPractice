package com.learningByDoing.learn_spring_framework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person (String name, int age, Address address){}
record Address (String add1, String city){}

@Configuration
public class HelloWorldConfiguration {

    @Bean
    public String name(){
        return "Abhishek";
    }

    @Bean
    public int age(){
        return 30;
    }

    @Bean
    public  Person person(){
        return new Person("Abhishek", 20, new Address("Prasundham", "Chinchwad"));
    }

    @Bean(name = "address2")
    public  Address address(){
        return new Address("Pearl Tower", "Pune");
    }

    @Bean
    public  Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public  Person person3parameters(String name, int age, Address address2){
        return new Person(name, age, address2);
    }


}
