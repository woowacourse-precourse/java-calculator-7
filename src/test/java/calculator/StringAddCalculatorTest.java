package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    void testNullOrEmptyStringReturnsZero() {
        assertEquals(0, StringAddCalculator.add(null));
        assertEquals(0, StringAddCalculator.add(""));
    }

    @Test
    void testCommaAndColonDelimiters() {
        assertEquals(6, StringAddCalculator.add("1,2:3"));
        assertEquals(10, StringAddCalculator.add("4,3:3"));
    }

    @Test
    void testCustomDelimiter() {
        assertEquals(6, StringAddCalculator.add("//;\n1;2;3"));
        assertEquals(10, StringAddCalculator.add("//#\n4#3#3"));
    }
    @Test
    void testNegativeNumbersThrowException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            StringAddCalculator.add("1,-2,3");
        });

        assertEquals("Negative numbers are not allowed: -2", exception.getMessage());
    }
}