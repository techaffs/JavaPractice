package com.learningByDoing;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionsPractice {

    public void ArrayListExample(){
        List<String> arrayList = new ArrayList<String>();

        arrayList.add("pune");
        arrayList.add("varanasi");
        arrayList.add("mumbai");
        arrayList.add("delhi");
        arrayList.add("sangli");
        arrayList.add("kolhapur");
        arrayList.add("nagpur");

        for(String city : arrayList)
            System.out.println(city);

        Iterator<String> iterator = arrayList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        arrayList.stream()
            .forEach(System.out::println);

    }
    
}
