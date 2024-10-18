package calculator.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumUtilTest {

    @Test
    void 정수_검증() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertTrue(NumUtil.isPositiveNum(String.valueOf((char) (c + i))));
        }
    }

    @Test
    void 정수_검증_예외__문자_포함() {
        // given
        String invalidChar = "1..";
        // when & then
        assertFalse(NumUtil.isPositiveNum(invalidChar));
    }

    @Test
    void 문자열을_정수로_변환() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertEquals(i, NumUtil.toLong(String.valueOf((char) (c + i))));
        }
    }

    @Test
    void 정수_변환_예외__문자_포함() {
        // given
        String invalidNum = "3.2";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toLong(invalidNum));
    }

    @Test
    void 정수_변환_예외__공백() {
        // given
        String invalidNum = " ";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toLong(invalidNum));
    }

    @Test
    void 숫자_변환_예외__음수() {
        // given
        long negative = -1L;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.toLong(String.valueOf(negative)));
    }

    @Test
    void 정수_변환__int_오버플로우() {
        // given
        long longValue = 2147483648L;
        // when & then
        long result = NumUtil.toLong(String.valueOf(longValue));
        assertEquals(longValue, result);
    }
}