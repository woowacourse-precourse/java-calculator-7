package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    StringCalculator calculator = new StringCalculator();

    @Test
    void calculateSumWithDefaultDelimiter() {
        String[] tokens = {"1", "2", "3"};
        int expected = 6;
        assertEquals(expected, calculator.calculateSum(tokens));
    }

    @Test
    void calculateSumWithCustomDelimiter() {
        String[] tokens = {"1", "2", "3"};
        int expected = 6;
        assertEquals(expected, calculator.calculateSum(tokens));
    }

    @Test
    void calculateSumWithNegativeNumbers() {
        String[] tokens = {"1", "-2", "3"};
        IllegalArgumentException exception
                = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateSum(tokens));
        assertEquals("음수는 허용되지 않습니다.(-2)", exception.getMessage());
    }

    @Test
    void calculateSumWithInvalidToken() {
        String[] tokens = {"1", "a", "3"};
        IllegalArgumentException exception
                = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateSum(tokens));
        assertEquals("유효하지 않은 값입니다.(a)", exception.getMessage());
    }
}