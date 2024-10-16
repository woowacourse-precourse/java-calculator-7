package calculator.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

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
                    .hasMessage("입력 문자열은 공백으로만 구성될 수 없습니다.");
        }
    }
}