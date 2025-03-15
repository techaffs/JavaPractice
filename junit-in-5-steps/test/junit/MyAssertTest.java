package junit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "Devops");

    @Test
    void test() {
        assertEquals(true,todos.contains("AWS"), "ERROR: Missing Value");
        assertEquals(3,todos.size(), "ERROR: Size not equal");
        assertTrue(todos.contains("AWS"));
//        assertFalse(todos.contains("AWS"));
        assertArrayEquals(new int[] {1,2}, new int[]{1,2});
    }
}
