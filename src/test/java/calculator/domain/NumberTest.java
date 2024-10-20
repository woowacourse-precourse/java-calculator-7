package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

class NumberTest {

    @DisplayName("정수가 아닌 문자열 예외 테스트")
    @Test
    void givenNonNumber_whenMakeNumberClass_thenThrowException() throws Exception
    {
        // given
        String input = "A";

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Number(input);
        });
        assertEquals(String.format("%s 값이 유효한 정수가 아닙니다.", input), exception.getMessage());
    }

    @DisplayName("null 예외 테스트")
    @Test
    void givenNull_whenMakeNumberClass_thenThrowException() throws Exception
    {
        // given
        String input = null;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Number(input);
        });
        assertEquals(String.format("%s 값이 유효한 정수가 아닙니다.", input), exception.getMessage());
    }

    @DisplayName("정수가 아닌 공백 문자열 예외 테스트")
    @Test
    void givenBlank_whenMakeNumberClass_thenThrowException() throws Exception
    {
        // given
        String input = "";

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Number(input);
        });
        assertEquals(String.format("%s 값이 유효한 정수가 아닙니다.", input), exception.getMessage());
    }

    @DisplayName("음의 정수 문자열 예외 테스트")
    @Test
    void givenNegativeNumber_whenMakeNumberClass_thenThrowException() throws Exception
    {
        // given
        String input = "-1";

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Number(input);
        });
        assertEquals(String.format("%s 값이 0이상의 정수가 아닙니다.", input), exception.getMessage());
    }

    @DisplayName("올바른 정수 문자열 테스트")
    @Test
    void givenCorrectNumber_whenMakeNumberClass_thenDone() throws Exception
    {
        // given
        String input = "1";
        int expected = 1;

        // when
        Number actual = new Number(input);

        // then
        assertEquals(expected, actual.getValue());
    }
}