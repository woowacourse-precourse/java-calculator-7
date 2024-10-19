package calculator.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private static final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("커스텀 구분자가 단일 문자가 아닌 경우 예외를 발생")
    void throws_when_length_is_not_character() {
        String input = "//--\n333";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.extractCustomDelimiter(input);
        });
    }
}
