package calculator.service;

import calculator.exception.ErrorMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    private static final CalculatorService calculatorService = new CalculatorService();

    @Test
    @DisplayName("커스텀 구분자가 단일 문자가 아닌 경우 예외를 발생")
    void throws_when_length_is_not_character() {
        String input = "//--\\n333";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.extractNumbers(input);
        });
    }

    @Test
    @DisplayName("커스텀 구분자에 숫자를 입력할 경우 예외를 발생")
    void throws_when_custom_delimiter_is_number() {
        String input = "//0\\n3333";

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
            calculatorService.extractNumbers(input);
        }).hasMessage(ErrorMessage.CUSTOM_TYPE_IS_NOT_NUMBER.getMessage());
    }

    @Test
    @DisplayName("기본 구분자를 커스텀으로 사용할 경우 예외 발생")
    void throws_when_default_is_customized() {
        String input = "//:\\n333";

        org.assertj.core.api.Assertions.assertThatThrownBy(() ->
                        calculatorService.extractNumbers(input))
                .hasMessage(ErrorMessage.CUSTOM_CANT_BE_DEFAULT.getMessage());
    }

    @Test
    @DisplayName("지정한 구분자 외에 다른 구분자를 입력하면 예외 발생")
    void throws_when_contains_none_customized() {
        String input = "//-\\n3,3,3-3";

        org.assertj.core.api.Assertions.assertThatThrownBy(() ->
                        calculatorService.extractNumbers(input))
                .hasMessage(ErrorMessage.IS_NOT_CUSTOMIZED.getMessage());
    }

    @Test
    @DisplayName("올바른 값을 입력한 경우 정상적으로 작동")
    void run_when_delimiter_is_correct_character() {
        String input = "//-\\n3-3-3-3";

        Assertions.assertDoesNotThrow(() -> calculatorService.extractNumbers(input));
    }
}
