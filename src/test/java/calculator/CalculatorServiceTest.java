package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("클라이언트 입력이 공백 일 때")
    void isEmptyInput() {
        // Given
        String userInput = " ";

        // When
        boolean result = calculatorService.isBlank(userInput);

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("클라이언트 입력이 길이가 0인 문자열일 때")
    void isBlankInput() {
        // Given
        String userInput = "";

        // When
        boolean result = calculatorService.isBlank(userInput);

        // Then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'1,2,3', ''",
            "'//k\\n1;2;3k4', 'k'"
    })
    @DisplayName("커스텀 구분자 추출 테스트")
    void parseCustomSeparator(String input, String customSeparator) {
        // Given & When
        String result = calculatorService.parseCustomSeparator(input);

        // Then
        assertThat(result).isEqualTo(customSeparator);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "'1,2,3', ''",
            "'//k\\n1k12k3', 'k'"
    })
    @DisplayName("유효한 입력, 유효성 검사")
    void isValidUserInput(String userInput, String customSeparator) {

        // Then
        assertDoesNotThrow(() -> CalculatorService.validate(userInput, customSeparator));
    }

    @ParameterizedTest
    @CsvSource(value = {
            "',3', ''",
            "'//k\\n1kkk', 'k'",
            "'//k\\n', 'k'",
            "'1,2,3//k\\n1,2', ''"
    })
    @DisplayName("유효하지 않은 입력, 유효성 검사")
    void isInvalidUserInput(String userInput, String customSeparator) {

        // Then
        assertThrowsExactly(IllegalArgumentException.class,
                () -> CalculatorService.validate(userInput, customSeparator));
    }

}