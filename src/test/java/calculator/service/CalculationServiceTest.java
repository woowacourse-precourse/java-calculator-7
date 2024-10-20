package calculator.test;

import calculator.service.CalculationService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationServiceTest {
    private final CalculationService calculationService = new CalculationService();

    @Test
    public void testCalculateWithDefaultDelimiters() {
        String input = "1,2:3";
        Number result = calculationService.calculate(input);
        assertEquals(6, result);
    }

    @Test
    public void testCalculateWithCustomDelimiter() {
        String input = "#\n1#2#3";
        Number result = calculationService.calculate(input);
        assertEquals(6, result);
    }

    @Test
    public void testCalculateWithNegativeNumbers() {
        String input = "1,-2,3";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculationService.calculate(input));
        assertEquals("양수만 허용됩니다.", exception.getMessage());
    }

    @Test
    public void testCalculateWithZero() {
        String input = "0,1,2";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculationService.calculate(input));
        assertEquals("All numbers must be positive", exception.getMessage());
    }
}
