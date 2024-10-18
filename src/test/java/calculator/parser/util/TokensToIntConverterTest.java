package calculator.parser.util;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.exception.IllegalArgumentExceptionEnum;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TokensToIntConverterTest {

    @Test
    @DisplayName("토큰을 Integer로 변환 성공")
    void convertTokensToIntegers() {
        // given
        TokensToIntConverter converter = new TokensToIntConverter();
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("1");
        tokens.add("2");
        tokens.add("3");

        // when
        ArrayList<Integer> doubleList = converter.convertToInt(tokens);

        // then
        ArrayList<Integer> expectedTokens = new ArrayList<>(List.of(1, 2, 3));
        assertIterableEquals(expectedTokens, doubleList);
    }

    @Test
    @DisplayName("빈 리스트 변환 시 빈 Integer 리스트 반환")
    void convertEmptyTokenListToIntegers() {
        // given
        TokensToIntConverter converter = new TokensToIntConverter();
        ArrayList<String> tokens = new ArrayList<>();

        // when
        ArrayList<Integer> doubleList = converter.convertToInt(tokens);

        // then
        ArrayList<Integer> expectedTokens = new ArrayList<>();
        assertIterableEquals(expectedTokens, doubleList);
    }

    @Test
    @DisplayName("음수 토큰 변환 시 예외 발생")
    void convertNegativeTokensToIntegersThrowsException() {
        // given
        TokensToIntConverter converter = new TokensToIntConverter();
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("-1");
        tokens.add("-2");
        tokens.add("-3");

        // when
        assertThrows(IllegalArgumentException.class, () -> converter.convertToInt(tokens),
                IllegalArgumentExceptionEnum.INVALID_CHARACTER.getMessage());
    }

    @Test
    @DisplayName("허용되지 않은 문자 토큰 변환 시 예외 발생")
    void convertInvalidCharacterTokensToIntegersThrowsException() {
        // given
        TokensToIntConverter converter = new TokensToIntConverter();
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("1");
        tokens.add("2");
        tokens.add("a");

        // when
        assertThrows(IllegalArgumentException.class, () -> converter.convertToInt(tokens),
                IllegalArgumentExceptionEnum.INVALID_CHARACTER.getMessage());
    }
}
