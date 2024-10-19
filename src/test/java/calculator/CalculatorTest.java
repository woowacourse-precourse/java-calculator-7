package calculator;

import calculator.model.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAddWithDefaultDelimiters() {
        assertEquals(6, calculator.add("1,2:3"));
    }

    @Test
    void testAddWithCustomDelimiter() {
        assertEquals(6, calculator.add("//;\\n1;2;3"));
    }

    @Test
    void testAddWithEmptyString() {
        assertEquals(0, calculator.add(""));
    }

    @Test
    void testAddWithSingleNumber() {
        assertEquals(3, calculator.add("3"));
    }

    @Test
    void testAddWithNegativeNumbersThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.add("1,-2,3"));
    }
}

