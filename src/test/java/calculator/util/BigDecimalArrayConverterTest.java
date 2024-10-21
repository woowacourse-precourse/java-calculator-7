package calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigDecimalArrayConverterTest {

    @Test
    @DisplayName("문자열 배열을 BigDecimal 배열로 변환")
    void convertStringArrayToBigDecimalArray() {
        // given
        String[] input = {"1.0", "2.5", "3.75"};

        // when
        BigDecimal[] result = BigDecimalArrayConverter.convert(input);

        // then
        assertEquals(new BigDecimal("1.0"), result[0]);
        assertEquals(new BigDecimal("2.5"), result[1]);
        assertEquals(new BigDecimal("3.75"), result[2]);
    }

    @Test
    @DisplayName("문자열 배열에 숫자가 아닌 값이 포함된 경우")
    void fail_invalidStringInArray() {
        // given
        String[] input = {"1.0", "abc", "3.75"};

        // when & then
        assertThrows(IllegalArgumentException.class,
            () -> BigDecimalArrayConverter.convert(input));
    }

    @Test
    @DisplayName("빈 문자열 배열의 경우")
    void fail_emptyStringInArray() {
        // given
        String[] input = {"1.0", "", "3.75"};

        // when & then
        assertThrows(IllegalArgumentException.class,
            () -> BigDecimalArrayConverter.convert(input));
    }

    @Test
    @DisplayName("빈 배열 처리는 0으로 반환")
    void success_emptyArray() {
        // given
        String[] input = {};

        // when
        BigDecimal[] result = BigDecimalArrayConverter.convert(input);

        // then
        assertEquals(0, result.length);
    }

    @Test
    @DisplayName("fail_공백 포함된 숫자는 예외처리")
    void fail_trimInputStrings() {
        // given
        String[] input = {" 1.0 ", " 2.5", "3.75 "};

        // when & then
        assertThrows(IllegalArgumentException.class,
            () -> BigDecimalArrayConverter.convert(input));
    }

}