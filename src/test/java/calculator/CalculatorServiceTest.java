package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}