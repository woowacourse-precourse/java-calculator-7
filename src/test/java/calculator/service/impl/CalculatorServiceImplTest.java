package calculator.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;

class CalculatorServiceImplTest {
    CalculatorService calculatorService = new CalculatorServiceImpl();

    @Test
    void defaultDelimiters() {
        assertEquals(6, calculatorService.add("1,2:3"));
    }

    @Test
    void customDelimiter() {
        assertEquals(6, calculatorService.add("//;\\n1;2;3"));
    }

    @Test
    void multipleCustomDelimiters() {
        assertEquals(6, calculatorService.add("//;\\n\\n1n2\\3"));
    }

    @Test
    void emptyString() {
        assertEquals(0, calculatorService.add(""));
    }

    @Test
    void numericCustomDelimiter() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.add("//1\\n1,2,3");
        });
        assertEquals("Custom delimiter cannot be a number: 1", exception.getMessage());
    }

    @Test
    void negativeNumbers() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.add("1,-2,3");
        });
        assertEquals("Negative numbers are not allowed", exception.getMessage());
    }

    @Test
    void consecutiveDelimiters() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.add("1,,2");
        });
        assertEquals("Consecutive delimiters are not allowed.", exception.getMessage());
    }

    @Test
    void delimiterAtStartOrEnd() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.add(",1,2,");
        });
        assertEquals("Input cannot start or end with a delimiter.", exception.getMessage());
    }
}