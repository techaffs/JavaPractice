package com.learningByDoing.learn_spring_aop.aopexample.data;

import com.learningByDoing.learn_spring_aop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] getData(){
//        try {
//            Thread.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        return new int[] {10, 20, 30, 40};
    }

}
