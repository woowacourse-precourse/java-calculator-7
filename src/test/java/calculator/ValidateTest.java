package calculator;

import calculator.controller.InputValidator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class ValidateTest {

    @Test
    @DisplayName("입력 문자열이 null일 때 IllegalArgumentException을 발생시킨다.")
    void validate_nullInput_throwsException() {
        // given
        String input = null;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));
    }

    @Test
    @DisplayName("입력 문자열이 빈 문자열일 때 IllegalArgumentException을 발생시킨다.")
    void validate_emptyInput_throwsException() {
        // given
        String input = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));
    }

    @Test
    @DisplayName("입력 문자열에 음수가 포함된 경우 IllegalArgumentException을 발생시킨다.")
    void validate_negativeNumber_throwsException() {
        // given
        String input = "1,-2,3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));
    }

    @Test
    @DisplayName("커스텀 구분자가 올바르게 지정되지 않은 경우 IllegalArgumentException을 발생시킨다.")
    void validate_invalidCustomDelimiter_throwsException() {
        // 커스텀 구분자가 지정되지 않고 사용할 때
        String input = "//1;2;3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함된 경우 IllegalArgumentException을 발생시킨다.")
    void validate_nonNumericCharacter_throwsException() {
        // given
        String input = "1,a:3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(input));
    }

    @Test
    @DisplayName("올바른 입력이 들어왔을 때 예외가 발생하지 않는다.")
    void validate_validInput_doesNotThrowException() {
        // given
        String input1 = "1,2:3";
        String input2 = "//;\n1;2:3";

        // when & then
        assertDoesNotThrow(() -> InputValidator.validate(input1));
        assertDoesNotThrow(() -> InputValidator.validate(input2));
    }
}