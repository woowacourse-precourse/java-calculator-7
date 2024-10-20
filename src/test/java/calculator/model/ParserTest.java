package calculator.model;

import calculator.ErrorMessage;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParserTest {
    @ParameterizedTest
    @DisplayName("기본 구분자로 문자열을 분리한다")
    @MethodSource("provideTestCaseForParse")
    void parse(String input, int numberOfNumbers) {
        Parser parser = new Parser(input);
        Assertions.assertThat(parser.parse().size()).isEqualTo(numberOfNumbers);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 문자열을 분리한다")
    @MethodSource("provideTestCaseForParseWithCustomDelimiter")
    void parseWithCustomDelimiter(String input, int numberOfNumbers) {
        Parser parser = new Parser(input);
        Assertions.assertThat(parser.parse().size()).isEqualTo(numberOfNumbers);
    }

    @Test
    @DisplayName("기본 구분자를 사용할 때 음수 또는 0이 포함된 문자열이 들어오면 예외를 발생시킨다")
    void parseWithNegativeNumber() {
        Parser parser = new Parser("1,2,0");
        Assertions.assertThatThrownBy(parser::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INTEGER_OUT_OF_RANGE.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자를 사용할 때 음수 또는 0 문자열이 들어오면 예외를 발생시킨다")
    void parseWithNegativeNumberWithCustomDelimiter() {
        Parser parser = new Parser("//a\\n1a2,-3");
        Assertions.assertThatThrownBy(parser::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INTEGER_OUT_OF_RANGE.getMessage());
    }

    private static Stream<Arguments> provideTestCaseForParse() {
        return Stream.of(
                Arguments.of("", 0),
                Arguments.of("1:2:3", 3),
                Arguments.of("1,2:3,4:5", 5)
        );
    }

    private static Stream<Arguments> provideTestCaseForParseWithCustomDelimiter() {
        return Stream.of(
                Arguments.of("//*\\n", 0),
                Arguments.of("//a\\n1a2a3", 3),
                Arguments.of("//?\\n1?2,3:4", 4),
                Arguments.of("//-\\n-1-2,3", 3)
        );
    }
}