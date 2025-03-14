package com.learningByDoing.restful_web_services.socialmedia.filtering;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        SomeBean someBean = new SomeBean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean); //Dynamic filtering
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2"); //Dynamic filtering
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter ); //Dynamic filtering
        mappingJacksonValue.setFilters(filters); //Dynamic filtering
        return mappingJacksonValue;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){

        List<SomeBean> someBeanList = Arrays.asList(new SomeBean("value1","value2","value3"),
                new SomeBean("value4","value5","value6"));

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeanList); //Dynamic filtering
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3"); //Dynamic filtering
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter ); //Dynamic filtering
        mappingJacksonValue.setFilters(filters); //Dynamic filtering

        return mappingJacksonValue;
    }
}
