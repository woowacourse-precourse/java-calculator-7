package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.CalculationManager.Calculator;
import org.junit.jupiter.api.Test;

public class StringAddCaculatorTest {
    private final Calculator calculator = new StringAddCalculator();

    @Test
    public void testEmptyString() {
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    public void testBasicSeperator() {
        assertEquals(3, calculator.calculate("1,2"));
        assertEquals(10, calculator.calculate("1,2:3:4"));
        assertEquals(5, calculator.calculate("3:2"));
    }

    @Test
    public void testCustomSeparator() {
        assertEquals(6, calculator.calculate("//-\\n1-2-3"));
        assertEquals(10, calculator.calculate("//+\\n1+2+3+4"));
        assertEquals(3, calculator.calculate("//[\\n1[2"));
    }
}
