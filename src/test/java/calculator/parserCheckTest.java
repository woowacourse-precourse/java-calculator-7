package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class parserCheckTest {

    @Test
    void testEmptyString() {
        // 빈 문자열일 경우 0을 반환하는지 확인
        assertEquals(0, parserCheck.parserOrThrow(""));
    }

    @Test
    void testValidPositiveNumber() {
        // 양수 문자열을 올바르게 변환하는지 확인
        assertEquals(123, parserCheck.parserOrThrow("123"));
    }

    @Test
    void testZero() {
        // "0" 문자열이 0으로 변환되는지 확인
        assertEquals(0, parserCheck.parserOrThrow("0"));
    }

    @Test
    void testNegativeNumber() {
        // 음수 문자열이 입력되었을 때 IllegalArgumentException이 발생하는지 확인
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> parserCheck.parserOrThrow("-123")
        );
        assertEquals("음수는 허용되지 않습니다: -123", thrown.getMessage());
    }

    @Test
    void testNonNumericString() {
        // 숫자가 아닌 문자열이 입력되었을 때 IllegalArgumentException이 발생하는지 확인
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> parserCheck.parserOrThrow("abc")
        );
        assertEquals("유효하지 않은 숫자 형식입니다: abc", thrown.getMessage());
    }
}

