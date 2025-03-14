package com.learningByDoing.learn_spring_framework.examples.a2;

import org.springframework.stereotype.Component;
import java.util.Arrays;

@Component
public class BusinessCalculationService {

    private DataService dataService;
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }

}
