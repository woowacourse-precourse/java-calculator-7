package calculator.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.utils.ErrorMessage;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class TokenProviderTest {

    private TokenProvider tokenProvider;

    @BeforeEach
    void setUp() {
        tokenProvider = new TokenProvider();
    }

    @ParameterizedTest
    @MethodSource("validInputProvider")
    @DisplayName("유효한 입력이 주어지면 공백이 제거된 토큰 리스트를 반환한다.")
    void givenValidInput_thenReturnsTokensWithoutSpaces(String input, List<String> expectedTokens) {
        List<String> tokens = tokenProvider.getTokens(input);
        assertThat(tokens).containsExactlyElementsOf(expectedTokens);
    }

    private static Stream<Arguments> validInputProvider() {
        return Stream.of(
                Arguments.of("1,2,3:4", List.of("1", "2", "3", "4")),
                Arguments.of("10:20", List.of("10", "20")),
                Arguments.of("5,6:7", List.of("5", "6", "7")),
                Arguments.of("//nice\\n5nice6nice7", List.of("5", "6", "7"))
        );
    }

    @ParameterizedTest
    @DisplayName("음수 또는 잘못된 형식의 입력이 주어지면 예외가 발생한다.")
    @ValueSource(strings = {"-1,2", "3:-4", "//n\\n-12n14"})
    void givenInvalidInput_thenThrowsException(String input) {
        assertThatThrownBy(() -> tokenProvider.getTokens(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_POSITIVE_NUMBERS_ALLOWED.getMessage());
    }
}
