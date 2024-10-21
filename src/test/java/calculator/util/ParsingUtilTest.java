package calculator.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.exception.CalculatorError;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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


    @ParameterizedTest(name = "{0} 파싱 테스트")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3", "1,2:3"})
    @DisplayName("Default 구분자로 입력 값이 기본 구분자로로 구분된 문자열을 List로 반환")
    void parseWithDefault_CommaDelimiter(String input) {
        //given
        final List<String> expected = List.of("1", "2", "3");

        // when
        var result = ParsingUtil.parseWithDefault(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest(name = "{0} 커스텀 구별자 확인")
    @ValueSource(strings = {"//; \n1;2;3", "//.\n1.2.3", "//|\n1|2|3"})
    @DisplayName("커스텀 구분자가 포함된 문자열 테스트")
    void containsCustomDelimiter(final String input) {

        // when
        var result = ParsingUtil.containsCustomDelimiter(input);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("커스텀 구분자 추출 테스트")
    void extractCustomDelimiter() {
        // given
        final String input = "//; \n1;2;3";
        final List<String> expected = List.of(";");

        // when
        var result = ParsingUtil.extractCustomDelimiter(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("여러 커스텀 구분자 추출 테스트")
    void extractCustomDelimiter_Multiple() {
        // given
        final String input = "//;\n//|\n1;2|3";
        final List<String> expected = List.of(";", "|");

        // when
        var result = ParsingUtil.extractCustomDelimiter(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3", "1,2:3"})
    @DisplayName("Default 구분자, 숫자 추출 테스트")
    void containsCustomDelimiter_False() {
        // given
        final String input = "1,2,3";

        // when
        var result = ParsingUtil.containsCustomDelimiter(input);

        // then
        assertThat(result).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "///\n1/2/3", "//|\n1|2|3"})
    @DisplayName("커스텀 구분자, 숫자 추출 테스트")
    void parseWithCustomDelimiter(String input) {
        // given
        final List<String> expected = List.of("1", "2", "3");

        // when
        var result = ParsingUtil.parseWithCustomDelimiter(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3", "1,2:3", "//;\n1;2;3", "///\n1/2/3", "//|\n1|2|3"})
    @DisplayName("통합 테스트 숫자 추출 테스트")
    void extractNumbers(String input) {
        // given
        final List<String> expected = List.of("1", "2", "3");

        // when
        var result = ParsingUtil.extractNumbers(input);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "13", "14"})
    @DisplayName("커스텀 구분자가 숫자일 경우 오류발생 테스트")
    void checkDelimiterFormat(String delimiter) {

        // when & then
        assertThatThrownBy(() -> ParsingUtil.checkDelimiterFormat(delimiter))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CalculatorError.DELIMITER_IS_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"//1\n1;2;3", "//2\n1/2/3", "//13\n1|2|3"})
    @DisplayName("")
    void checkDelimiterFormat_Exception(String input) {

        // when & then
        assertThatThrownBy(() -> ParsingUtil.extractNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CalculatorError.DELIMITER_IS_NUMBER.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자가 빈 문자열일 경우 오류발생 테스트")
    void checkDelimiterEmpty() {
        // given
        final String input = "// \n1;2;3";

        // when & then
        assertThatThrownBy(() -> ParsingUtil.extractCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(CalculatorError.DELIMITER_IS_EMPTY.getMessage());
    }
}