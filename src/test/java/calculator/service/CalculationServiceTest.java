package calculator.service;

import calculator.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculationServiceTest {
    private final CalculationService calculationService = new CalculationService();

    @Test
    public void testCalculateWithDefaultDelimiters() {
        String input = "1,2:3";
        Number result = calculationService.calculate(input);
        assertEquals(6L, result);  // 수정: 기대 값을 Long 타입으로 변경
    }

    @Test
    public void testCalculateWithCustomDelimiter() {
        String input = "//#\n1#2#3";
        Number result = calculationService.calculate(input);
        assertEquals(6L, result);  // 수정: 기대 값을 Long 타입으로 변경
    }

    @Test
    public void testCalculateWithNegativeNumbers() {
        String input = "1,-2,3";
        Exception exception = assertThrows(InvalidNumberException.class, () -> calculationService.calculate(input));
        assertEquals("숫자는 양수만 가능합니다", exception.getMessage());
    }

    @Test
    public void testCalculateWithZero() {
        String input = "0,1,2";
        Exception exception = assertThrows(InvalidNumberException.class, () -> calculationService.calculate(input));
        assertEquals("숫자는 양수만 가능합니다", exception.getMessage());
    }
}
