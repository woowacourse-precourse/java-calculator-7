package calculator.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {
    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testCalculateWithValidInput() {
        assertEquals(6, calculatorService.calculate("1,2,3"));
        assertEquals(6, calculatorService.calculate("1:2:3"));
        assertEquals(6, calculatorService.calculate("1,2:3"));
        assertEquals(6, calculatorService.calculate("//;\n1;2;3"));
    }

    @Test
    public void testCalculateWithEmptyString() {
        assertEquals(0, calculatorService.calculate(""));
    }

    @Test
    public void testCalculateWithWhitespace() {
        assertEquals(0, calculatorService.calculate("   "));
    }

    @Test
    public void testCalculateWithSpacesInNumbers() {
        assertEquals(6, calculatorService.calculate("1, 2, 3"));
        assertEquals(6, calculatorService.calculate("1 : 2 : 3"));
        assertEquals(6, calculatorService.calculate("//;\n1; 2; 3"));
    }

    @Test
    public void testCalculateWithInvalidNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate("1,a,3");
        });
        assertEquals("유효하지 않은 숫자입니다: a", exception.getMessage());
    }

    @Test
    public void testCalculateWithNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.calculate("1,-2,3");
        });
        assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    }
}
