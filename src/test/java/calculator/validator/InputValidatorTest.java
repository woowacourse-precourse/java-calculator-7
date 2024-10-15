package calculator.validator;

import calculator.constants.ErrorMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {
    private static InputValidator inputValidator;

    @BeforeAll
    static void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("문자열 맨 앞 또는 맨 뒤에 공백이 포함된 경우, 예외가 발생한다.")
    public void validateStripTest() {
        // given
        String input = " 1";

        // when & then
        assertThatThrownBy(() -> inputValidator.validateStrip(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NOT_ALLOWED_FIRST_LAST_BLANK);
    }

    @Test
    @DisplayName("정수가 입력되지 않은 경우, 예외가 발생한다.")
    public void validateIntegerTest() {
        // given
        String[] elements = new String[]{ "a,2,3" };

        // when & then
        assertThatThrownBy(() -> inputValidator.validateInteger(elements))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.ONLY_ALLOWED_INTEGER);
    }
}
