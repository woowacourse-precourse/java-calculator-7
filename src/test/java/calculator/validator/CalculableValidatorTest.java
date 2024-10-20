package calculator.validator;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.common.Delimiters;
import calculator.enums.ErrorMessage;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CalculableValidatorTest {

    @Nested
    @DisplayName("validate 메서드는")
    class ValidateMethod {

        @Test
        void 허용된_구분자만_사용된_경우_예외를_발생시키지_않는다() {
            // given
            Delimiters delimiters = new Delimiters();
            String input = "1,2:3";

            // when & then
            assertThatNoException().isThrownBy(() -> CalculableValidator.validate(input, delimiters));
        }

        @Test
        void 허용되지_않은_구분자가_포함된_경우_예외를_발생시킨다() {
            // given
            Delimiters delimiters = new Delimiters();
            String input = "1@2:3";

            // when & then
            assertThatThrownBy(() -> CalculableValidator.validate(input, delimiters))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_CHAR_INCLUDED.getMessage());
        }

        @Test
        void 커스텀_구분자를_포함한_경우_예외를_발생시키지_않는다() {
            // given
            Delimiters delimiters = new Delimiters();
            delimiters.addCustomDelimiters(Set.of("&"));
            String input = "1&2,3";

            // when & then
            assertThatNoException().isThrownBy(() -> CalculableValidator.validate(input, delimiters));
        }

        @Test
        void 허용되지_않은_구분자와_커스텀_구분자가_같이_있는_경우_예외를_발생시킨다() {
            // given
            Delimiters delimiters = new Delimiters();
            delimiters.addCustomDelimiters(Set.of("&"));
            String input = "1&2;3";

            // when & then
            assertThatThrownBy(() -> CalculableValidator.validate(input, delimiters))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_CHAR_INCLUDED.getMessage());
        }

        @Test
        void 구분자가_숫자_사이에_위치하는_경우_검증에_성공한다() {
            // given
            String input = "1@2:3";
            Delimiters delimiters = new Delimiters();
            delimiters.addCustomDelimiters(Set.of("@"));

            // when & then
            assertThatNoException().isThrownBy(() -> CalculableValidator.validate(input, delimiters));
        }

        @Test
        @DisplayName("구분자가 숫자 사이에 위치하지 않는 경우 예외가 발생한다")
        void 구분자가_숫자_사이에_위치하지_않는_경우_예외_발생() {
            // given
            String input = "1,,2:3";
            Delimiters delimiters = new Delimiters();

            // when & then
            assertThatThrownBy(() -> CalculableValidator.validate(input, delimiters))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.DELIMITER_MUST_BE_BETWEEN_NUMBERS.getMessage());
        }

        @Test
        void 숫자가_너무_큰_경우_NUMBER_TOO_LARGE_예외를_발생시킨다() {
            // given
            String input = "9999999999999999999999999";
            Delimiters delimiters = new Delimiters();

            // when & then
            assertThatThrownBy(() -> CalculableValidator.validate(input, delimiters))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.NUMBER_TOO_LARGE.getMessage());
        }

        @Test
        void 숫자가_Long_범위_내에_있으면_예외를_발생시키지_않는다() {
            // given
            String input = "100";
            Delimiters delimiters = new Delimiters();

            // when & then
            assertThatNoException().isThrownBy(() -> CalculableValidator.validate(input, delimiters));
        }
    }
}