package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    void testNullOrEmptyStringReturnsZero() {
        assertEquals(0, StringAddCalculator.add(null));
        assertEquals(0, StringAddCalculator.add(""));
    }
}
