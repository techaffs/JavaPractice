package com.learningByDoing.learn_spring_aop.aopexample.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] getData(){
        return new int[] {10, 20, 30, 40};
    }

}
