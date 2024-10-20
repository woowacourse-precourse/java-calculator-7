package calculator.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testSumWithValidNumbers() {
        assertEquals(6, calculator.sum("1,2,3"));
    }

    @Test
    public void testSumWithEmptyString() {
        assertEquals(0, calculator.sum(""));
    }

    @Test
    public void testSumWithSpaces() {
        assertEquals(6, calculator.sum(" 1 , 2 , 3 "));
    }

    @Test
    public void testSumWithNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum("1,-2,3");
        });
        assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    }

    @Test
    public void testSumWithInvalidNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum("1,a,3");
        });
        assertEquals("유효하지 않은 숫자입니다: a", exception.getMessage());
    }

    // 기본 구분자로 숫자 분리
    @Test
    public void testSumWithCommaSeparator() {
        assertEquals(6, calculator.sum("1,2,3"));
    }

    @Test
    public void testSumWithColonSeparator() {
        assertEquals(6, calculator.sum("1:2:3"));
    }

    @Test
    public void testSumWithMixedSeparators() {
        assertEquals(6, calculator.sum("1,2:3"));
    }

    @Test
    public void testSumWithSpacesAndSeparators() {
        assertEquals(6, calculator.sum("1, 2 : 3"));
    }

    // 커스텀 구분자 지원
    @Test
    public void testSumWithCustomDelimiter() {
        assertEquals(6, calculator.sum("//;\n1;2;3"));
    }

    @Test
    public void testSumWithCustomDelimiterAndSpaces() {
        assertEquals(6, calculator.sum("//;\n1; 2; 3"));
    }

    @Test
    public void testSumWithCustomDelimiterAndInvalidNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum("//;\n1;a;3");
        });
        assertEquals("유효하지 않은 숫자입니다: a", exception.getMessage());
    }

    @Test
    public void testSumWithCustomDelimiterAndNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sum("//;\n1;-2;3");
        });
        assertEquals("음수는 허용되지 않습니다: -2", exception.getMessage());
    }
}