package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    void testCalculateWithDefaultDelimiters() {
        assertEquals(6, calculator.calculate("1,2:3"));
    }

    @Test
    void testCalculateWithCustomDelimiter() {
        assertEquals(6, calculator.calculate("//;\n1;2;3"));
    }

    @Test
    void testCalculateWithEmptyString() {
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    void testCalculateWithSingleNumber() {
        assertEquals(5, calculator.calculate("5"));
    }

    @Test
    void testCalculateWithNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("1,-2,3"));
        assertEquals("음수는 입력할 수 없습니다.", exception.getMessage());
    }

    @Test
    void testCalculateWithInvalidNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.calculate("1,a,3"));
        assertEquals("잘못된 숫자 형식입니다.", exception.getMessage());
    }
}