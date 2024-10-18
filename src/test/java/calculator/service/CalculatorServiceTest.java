package calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    @Test
    void testService() {
        String testInput2 = "//}\n4}5}6";
        CalculatorService.printResultOfSum(testInput2);
    }
}