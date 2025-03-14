package com.learningByDoing.learn_spring_boot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyServiceController {

    @Autowired
    private CurrencyServiceConfiguration configuration;

    @RequestMapping("/currency-config")
    public CurrencyServiceConfiguration retrieveCurrencyConfiguration(){
        return configuration;
    }
}
