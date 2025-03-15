package junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    void calculateSum() {
        //        int result = math.calculateSum(new int[]{1,2,3});
//        System.out.println(result);
        //        int expected = 6;
        assertEquals(6, math.calculateSum(new int[]{1,2,3}));
//        assertEquals(expected, result);
        //Absense of failure is success
        //Test Conditions or Asserts
    }

    @Test
    void noInput() {
        assertEquals(0, math.calculateSum(new int[]{}));
    }
}