package com.learningByDoing;

import java.util.List;

import com.learningByDoing.CollectionsPractice.*;


public class Main {
    public static void main(String[] args) {
        //"pune", "varanasi", "mumbai", "delhi", "sangli"
        List<String> cities = List.of("pune", "varanasi", "mumbai", "delhi", "sangli");
        printCityNames(cities);

        City city = new City("Pune", 1000000);
        City clonedCity = new City(city.getName(), city.getPopulation()); // Deep Cloning the city object
        System.out.println(clonedCity.getCityInfo());
        System.out.println("Original City: " + city);
        System.out.println("Cloned City: " + clonedCity);

       // ArrayListExample();
       CollectionsPractice arrayListExample = new CollectionsPractice();
       arrayListExample.ArrayListExample();
       
        
    }

    

    public static void printCityNames(List<String> cities) {
        cities.stream()
                .map(city -> city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase())
                .sorted()
                .forEach(System.out::println);
    }

    
}

final class City { // This class is immutable
    private final String name;
    private final int population;

    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getCityInfo() {
        return "City: " + name + ", Population: " + population;
    }
}

