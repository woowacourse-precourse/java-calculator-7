package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

}