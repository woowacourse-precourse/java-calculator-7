package calculator.controller;

import static calculator.controller.DelimiterSeparator.detectCustomDelimiter;
import static calculator.controller.DelimiterSeparator.registerCustomDelimiter;
import static calculator.controller.DelimiterSeparator.validateDelimiter;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class DelimiterSeparatorTest {

    @Test
    void 숫자_시작_구분자_등록_안함() {
        String userInput = "123";
        int index = detectCustomDelimiter(userInput);
        assertEquals(0, index);
    }

    @Test
    void 문자_시작_구분자_등록_성공() {
        String userInput = "//;\\n123";
        int index = detectCustomDelimiter(userInput);
        assertEquals(5, index);
    }

    @Test
    public void 구분자_등록_형식_에러() {
        String userInput = ";123";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registerCustomDelimiter(userInput);
        });
        assertEquals("잘못된 형식입니다.", exception.getMessage());
    }

    @Test
    public void 구분자_등록_형식_에러2() {
        String userInput = "//;123";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            registerCustomDelimiter(userInput);
        });
        assertEquals("잘못된 형식입니다.", exception.getMessage());
    }

    @Test
    public void 구분자_등록_성공() {
        String userInput = "//;\\n123";
        int result = registerCustomDelimiter(userInput);
        assertEquals(5, result);
    }

    @Test
    public void 구분자_에러() {
        String userInput = "3";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateDelimiter(userInput);
        });
        assertEquals("잘못된 형식입니다.", exception.getMessage());
    }

    @Test
    public void 구분자_에러2() {
        String userInput = "[";
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            validateDelimiter(userInput);
        });
        assertEquals("잘못된 형식입니다.", exception.getMessage());
    }

    @Test
    public void 올바른_구분자() {
        String userInput = ":";
        assertDoesNotThrow(() -> {
            validateDelimiter(userInput);
        });
    }
}
