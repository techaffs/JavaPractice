package com.learningByDoing.mockito_demo.business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImplStubTest {

    @Test
    void findTheGreatestFromAllData_basicScenario(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGraetestFromAllData();
        assertEquals(25, result);

    }
}

class DataServiceStub implements DataService{
    @Override
    public int[] getAllData(){
        return new int[]{25, 15,5};
    }
}
