package calculator.delimiter.filter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NegativeNumberValidationFilterTest {
    private NegativeNumberValidationFilter filter = new NegativeNumberValidationFilter();

    @Test
    @DisplayName("음수가 들어오면 IllegalException 예외가 발생한다.")
    void throw_illegal_argument_exception_when_negative_number_is_input_then() {
        // given
        String s = "//||\\n1||2||-3||4";

        // when, then
        assertThatThrownBy(() -> filter.validate(s))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("음수가 포함되어 있습니다.");
    }

}