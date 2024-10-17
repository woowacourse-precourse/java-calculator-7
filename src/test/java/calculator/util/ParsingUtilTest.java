package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.CalculatorError;
import java.util.List;
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

    @Test
    @DisplayName("입력 값이 공백만 포함한 문자열일 경우 IllegalArgumentException 발생")
    void parseWithDefault_Blank() {
        // given
        final String input = " ";

        // when & then
        assertThatThrownBy(() -> ParsingUtil.parseWithDefault(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CalculatorError.INPUT_IS_NULL_OR_EMPTY.getMessage());
    }


    @Test
    @DisplayName("Default 구분자로 입력 값이 기본 구분자로로 구분된 문자열을 List로 반환")
    void parseWithDefault_CommaDelimiter() {
        // given
        final String input = "1,2:3";
        final var expected = List.of("1", "2", "3");
        // when
        var result = ParsingUtil.parseWithDefault(input);

        // then
        assertThat(result).isEqualTo(expected);
    }
}