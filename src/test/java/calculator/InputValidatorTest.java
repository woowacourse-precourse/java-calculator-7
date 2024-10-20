package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputValidatorTest {

    @Test
    void isInvalidNumberTest() {
        // given
        final InputValidator inputValidator = new InputValidator();
        final String number = "-1";

        // when && then
        assertThatThrownBy(() -> inputValidator.isInvalidNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isCustomPatternTest() {
        // given
        final InputValidator inputValidator = new InputValidator();
        final String input = "//;\\n1;2;3";
        // when
        final boolean isCustomPattern = inputValidator.isCustomPattern(input);
        // then
        assertThat(isCustomPattern).isTrue();
    }
}
