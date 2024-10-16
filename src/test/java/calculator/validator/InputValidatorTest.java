package calculator.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

import calculator.enums.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Nested
    @DisplayName("validateBlank 메서드는")
    class ValidateBlank {

        @Test
        void 빈_문자열인_경우_예외를_발생시키지_않는다() {
            // given
            String emptyInput = "";

            // when & then
            assertThatNoException().isThrownBy(() -> InputValidator.validateBlank(emptyInput));
        }

        @Test
        void 공백_문자열인_경우_예외를_발생시킨다() {
            // given
            String blankInput = " ";

            // when & then
            assertThatThrownBy(() -> InputValidator.validateBlank(blankInput))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }

    @Test
    void 입력_문자열의_첫_번째_문자가_공백인_경우_예외를_발생시킨다() {
        // given
        String blankInput = " 4,2:";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateIsStartBlank(blankInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.FIRST_CHAR_CANNOT_BE_SPACE.getMessage());
    }

    @Test
    void 입력_문자열의_마지막_문자가_공백인_경우_예외를_발생시킨다() {
        // given
        String blankInput = "1:2, ";

        // when & then
        assertThatThrownBy(() -> InputValidator.validateIsEndBlank(blankInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.LAST_CHAR_CANNOT_BE_SPACE.getMessage());
    }
}