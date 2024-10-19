package calculator.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionTest {
    @Test
    void testPickNumbers() {
        Addition addition = new Addition();
        int result = addition.pickNumbers(Arrays.asList("1", ",", "2", ":", "3"));
        assertEquals(6, result);
    }

//    @Test
//    void testSum() {
//        Addition addition = new Addition();
//        int result = addition.sum(new int[]{1, 2, 3});
//        assertEquals(6, result);
//    }
}
