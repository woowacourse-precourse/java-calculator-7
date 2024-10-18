package calculator.sumCalculator.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class DelimiterParserTest {

    private DelimiterParser delimiterParser;

    @BeforeEach
    void setUp() {
        delimiterParser = new DelimiterParser();
    }

    @Test
    @DisplayName("커스텀 구분자 한글자를 추출한다.")
    void extractCustomDelimiter() {
        String input = "//;\n1;2;3";
        String customDelimiter = delimiterParser.extractCustomDelimiter(input);
        assertThat(";").isEqualTo(customDelimiter);
    }

    @Test
    @DisplayName("커스텀 구분자 문자열을 추출한다.")
    void extractLettersCustomDelimiter() {
        String input1 = "//HelloWorld!\n";
        String input2 = "//a1b2c3\n";
        String customDelimiter1 = delimiterParser.extractCustomDelimiter(input1);
        String customDelimiter2 = delimiterParser.extractCustomDelimiter(input2);
        assertThat("HelloWorld!").isEqualTo(customDelimiter1);
        assertThat("a1b2c3").isEqualTo(customDelimiter2);
    }

    @Test
    @DisplayName("예외 테스트 - 커스텀 구분자에 공백이 포함되면 추출 실패한다.")
    void failContainsSpaces() {
        String input = "//Hello World\n";
        assertThatThrownBy(() -> delimiterParser.extractCustomDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 커스텀 구분자입니다.");
    }

    @Test
    @DisplayName("예외 테스트 - 선언하지 않은 커스텀 구분자를 사용하여 숫자 추출을 실패한다.")
    void failExtractNumbersContainCustomDelimiter() {
        String expression = "1^^2&^3";
        assertThatThrownBy(() -> delimiterParser.checkCustomDelimiterInExpression(expression, "^^"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("연산식에 올바르지 않은 커스텀 구분자가 포함되어 있습니다.");
    }
}