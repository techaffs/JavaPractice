package com.learningByDoing.mockito_demo.business;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;


    @Test
    void findTheGreatestFromAllData_basicScenario(){
        when(dataServiceMock.getAllData()).thenReturn(new int[]{25,15,5});
        assertEquals(25, businessImpl.findTheGraetestFromAllData());
    }

//    @Test
//    void findTheGreatestFromAllData_basicScenario(){
//
//        DataService dataServiceMock = mock(DataService.class);
//        when(dataServiceMock.getAllData()).thenReturn(new int[]{25,15,5});
//        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
//        int result = businessImpl.findTheGraetestFromAllData();
//        assertEquals(25, result);
//
//    }
}

