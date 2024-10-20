package calculator.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumUtilTest {

    @DisplayName("[정상] 양수인지 검증")
    @Test
    void checkPositiveInt() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertTrue(NumUtil.isPositiveNum(String.valueOf((char) (c + i))));
        }
    }

    @DisplayName("[양수 검증 실패] 문자가 포함된 경우")
    @Test
    void invalidNum() {
        // given
        String invalidChar = "1..";
        // when & then
        assertFalse(NumUtil.isPositiveNum(invalidChar));
    }

    @DisplayName("[정상] 문자열을 양수로 변환")
    @Test
    void parseLong() {
        // given
        char c = '0';
        // when & then
        for (int i = 0; i < 10; i++) {
            assertEquals(i, NumUtil.parseLong(String.valueOf((char) (c + i))));
        }
    }

    @DisplayName("[양수 변환 예외] 문자가 포함된 경우")
    @Test
    void invalidParseLongWithChar() {
        // given
        String invalidNum = "3.2";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.parseLong(invalidNum));
    }

    @DisplayName("[양수 변환 예외] 빈 문자열인 경우")
    @Test
    void invalidParseLongWithEmpty() {
        // given
        String invalidNum = "";
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.parseLong(invalidNum));
    }

    @DisplayName("[양수 변환 예외] 음수인 경우")
    @Test
    void invalidParseLongWithNegative() {
        // given
        long negative = -1L;
        // when & then
        assertThrows(IllegalArgumentException.class, () -> NumUtil.parseLong(String.valueOf(negative)));
    }

    @DisplayName("[정상] int 오버플로우인 경우")
    @Test
    void intOverFlow() {
        // given
        long longValue = 2147483648L;
        // when & then
        long result = NumUtil.parseLong(String.valueOf(longValue));
        assertEquals(longValue, result);
    }
}