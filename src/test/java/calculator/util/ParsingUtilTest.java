package calculator.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.CalculatorError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParsingUtilTest {

    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException 발생")
    void parseWithDefault_NullOrEmpty() {
        // given
        final String input = null;

        // when & then
        assertThatThrownBy(() -> ParsingUtil.parseWithDefault(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CalculatorError.INPUT_IS_NULL_OR_EMPTY.getMessage());
    }

    @Test
    @DisplayName("입력 값이 빈 문자열일 경우 IllegalArgumentException 발생")
    void parseWithDefault_Empty() {
        // given
        final String input = "";

        // when & then
        assertThatThrownBy(() -> ParsingUtil.parseWithDefault(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CalculatorError.INPUT_IS_NULL_OR_EMPTY.getMessage());
    }
}