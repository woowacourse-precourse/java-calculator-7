package calculator.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("커스텀 구분자와 숫자를 입력할 경우 정상적으로 동작한다.")
    void validateInputWithCustomDelimiter() {
        //given
        String input = "//;\\n1,2,3";

        // when, then
        assertDoesNotThrow(() -> inputValidator.validateInput(input));
    }

    @Test
    @DisplayName("커스텀 구분자 없이 숫자를 입력할 경우 정상적으로 동작한다.")
    void validateInputWithoutCustomDelimiter() {
        // given
        String input = "1,2,3";

        // when, then
        assertDoesNotThrow(() -> inputValidator.validateInput(input));
    }

    @Test
    @DisplayName("커스텀 구분자만 입력할 경우 예외가 발생한다.")
    void throwExceptionWhenInvalidInput() {
        // given
        String input = "//;n";

        // when, then
        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열을 입력할 경우 예외가 발생한다.")
    void throwExceptionWhenEmptyInput() {
        // given
        String input = "";

        // when, then
        assertThatThrownBy(() -> inputValidator.validateInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}