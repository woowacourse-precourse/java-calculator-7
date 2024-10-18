package calculator.Utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    InputValidator validator = new InputValidator();

    @Test
    @DisplayName("숫자만 포함된 입력을 유효성 검사할 때 예외가 발생하지 않음")
    void 숫자만_포함된_입력() {
        String[] userInput = {"123", "456"};
        assertDoesNotThrow(() -> validator.validateNumericCharacters(userInput));
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 포함된 입력을 유효성 검사할 때 예외 발생")
    void 숫자가아닌_다른문자가_포함된_입력() {
        String[] userInput = {"123", "456", "abc"};
        assertThatThrownBy(() -> validator.validateNumericCharacters(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 빈 값을 입력하면 True를 반환한다.")
    void 빈_값을_입력했을_경우() {
        String userInput = "";

        boolean result = validator.validateEmptyInput(userInput);

        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("사용자가 빈 값을 입력하지 않으면 False를 반환한다.")
    void 빈_값을_입력하지_않았을_경우() {
        String userInput = "1,2:3";

        boolean result = validator.validateEmptyInput(userInput);

        Assertions.assertFalse(result);
    }
}