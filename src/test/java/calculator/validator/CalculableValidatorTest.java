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
    @DisplayName("validateAllowedDelimiters 메서드는")
    class ValidateAllowedDelimitersMethod {

        @Test
        void 허용된_구분자만_사용된_경우_예외를_발생시키지_않는다() {
            // given
            Delimiters delimiters = new Delimiters();
            String input = "1,2:3";

            // when & then
            assertThatNoException().isThrownBy(() -> CalculableValidator.validateAllowedDelimiters(input, delimiters));
        }

        @Test
        void 허용되지_않은_구분자가_포함된_경우_예외를_발생시킨다() {
            // given
            Delimiters delimiters = new Delimiters();
            String input = "1@2:3";

            // when & then
            assertThatThrownBy(() -> CalculableValidator.validateAllowedDelimiters(input, delimiters))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_DELIMITER_INCLUDED.getMessage());
        }

        @Test
        void 커스텀_구분자를_포함한_경우_예외를_발생시키지_않는다() {
            // given
            Delimiters delimiters = new Delimiters();
            delimiters.addCustomDelimiters(Set.of("&"));
            String input = "1&2,3";

            // when & then
            assertThatNoException().isThrownBy(() -> CalculableValidator.validateAllowedDelimiters(input, delimiters));
        }

        @Test
        void 허용되지_않은_구분자와_커스텀_구분자가_같이_있는_경우_예외를_발생시킨다() {
            // given
            Delimiters delimiters = new Delimiters();
            delimiters.addCustomDelimiters(Set.of("&"));
            String input = "1&2;3";

            // when & then
            assertThatThrownBy(() -> CalculableValidator.validateAllowedDelimiters(input, delimiters))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.INVALID_DELIMITER_INCLUDED.getMessage());
        }
    }
}