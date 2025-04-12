package com.learningByDoing.mockito_demo.business;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        this.dataService = dataService;
    }

    public int findTheGraetestFromAllData(){
           int[] data = dataService.getAllData();
           int greatestValue = Integer.MIN_VALUE;
           for(int value:data){
               if(value > greatestValue)
                   greatestValue = value;
           }
           return greatestValue;
    }
}

interface DataService{
    int[] getAllData();
}