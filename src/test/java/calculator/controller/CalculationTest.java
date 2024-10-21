package calculator.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {
    @Test
    void testCalculate_SimpleSum() {
        Calculation calculation = new Calculation();
        List<String> input = Arrays.asList("1", "+", "2", "+", "3"); // "1 + 2 + 3"

        int result = calculation.calculate(input);

        assertEquals(6, result); // 1 + 2 + 3 = 6
    }

    @Test
    void testCalculate_SingleNumber() {
        Calculation calculation = new Calculation();
        List<String> input = Arrays.asList("5"); // "5"

        int result = calculation.calculate(input);

        assertEquals(5, result); // 5 = 5
    }

    @Test
    void testCalculate_NoNumbers() {
        Calculation calculation = new Calculation();
        List<String> input = Arrays.asList(); // 빈 리스트

        int result = calculation.calculate(input);

        assertEquals(0, result); // 합계가 없으므로 0
    }

    @Test
    void testCalculate_NegativeNumbers() {
        Calculation calculation = new Calculation();
        List<String> input = Arrays.asList("-1", "+", "-2", "+", "-3"); // "-1 + -2 + -3"

        int result = calculation.calculate(input);

        assertEquals(-6, result); // -1 + -2 + -3 = -6
    }

    @Test
    void testCalculate_MixedNumbers() {
        Calculation calculation = new Calculation();
        List<String> input = Arrays.asList("10", "+", "20", "+", "30", "+", "40"); // "10 + 20 + 30 + 40"

        int result = calculation.calculate(input);

        assertEquals(100, result); // 10 + 20 + 30 + 40 = 100
    }
}
