package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomTextCalculatorTest {

    @Test
    void testEmptyInput() {
        assertEquals(0, CustomTextCalculator.calculate(""));
        assertEquals(0, CustomTextCalculator.calculate("   "));
    }

    @Test
    void testSingleNumber() {
        assertEquals(1, CustomTextCalculator.calculate("1"));
        assertEquals(5, CustomTextCalculator.calculate("5"));
    }

    @Test
    void testSplitter() {
        assertEquals(3, CustomTextCalculator.calculate("1,2"));
        assertEquals(6, CustomTextCalculator.calculate("1,2,3"));
        assertEquals(6, CustomTextCalculator.calculate("1,2:3"));
        assertEquals(10, CustomTextCalculator.calculate("1,2:3,4"));
    }

    @Test
    void testCustomSplitter() {
        assertEquals(6, CustomTextCalculator.calculate("//;\n1;2;3"));
        assertEquals(7, CustomTextCalculator.calculate("//&\n2&5"));
    }

    @Test
    void testInvalidNumberException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            CustomTextCalculator.calculate("1,a");
        });
        assertEquals("유효하지 않은 입력입니다. 숫자만 포함해야 합니다.", exception.getMessage());
    }
}
