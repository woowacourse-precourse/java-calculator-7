package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.domain.exception.CalculatorException;
import calculator.dto.request.CalculatorRequest;
import java.util.regex.Pattern;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ViewCalculatorParserTest {
    @Test
    @DisplayName("기본 구분자 반환 테스트")
    void testDefaultDelimiters() {
        String input = "1,2:3";
        String expectedDelimiters = ",|:";
        CalculatorRequest calculatorRequest = ViewCalculatorParser.parseDelimitersAndInput(input);
        assertThat(calculatorRequest.delimiters()).isEqualTo(expectedDelimiters);
    }

    @Test
    @DisplayName("단일 문자 커스텀 구분자 반환 테스트")
    void testSingleCustomDelimiter() {
        String input = "//^\\n1^2^3";
        String expectedDelimiters = ",|:|" + Pattern.quote("^"); // ",|:|^"
        CalculatorRequest calculatorRequest = ViewCalculatorParser.parseDelimitersAndInput(input);
        assertThat(calculatorRequest.delimiters()).isEqualTo(expectedDelimiters);
    }

    @Test
    @DisplayName("커스텀 구분자가 여러개인 예외 테스트")
    void testInvalidMultiCustomDelimiters() {
        String invalidInput = "//^*\\n1^2^3"; // 구분자가 여러개인 상황

        assertThatThrownBy(() -> ViewCalculatorParser.parseDelimitersAndInput(invalidInput))
                .isInstanceOf(CalculatorException.class);
    }

    @Test
    @DisplayName("잘못된 커스텀 구분자 형식 예외 테스트")
    void testInvalidCustomDelimiterFormat() {
        String invalidInput = "//^1^2^3"; // \n 없음

        assertThatThrownBy(() -> ViewCalculatorParser.parseDelimitersAndInput(invalidInput))
                .isInstanceOf(CalculatorException.class);
    }

    @Test
    @DisplayName("빈 문자열이 주어진 경우 기본 구분자 반환 테스트")
    void testEmptyInputParameter() {
        String emptyInput = ""; // \n 없음

        String expectedDelimiters = ",|:";
        CalculatorRequest calculatorRequest = ViewCalculatorParser.parseDelimitersAndInput(emptyInput);
        assertThat(calculatorRequest.delimiters()).isEqualTo(expectedDelimiters);
    }

    @Test
    @DisplayName("구분자 정보가 없는 너무 짧은 문자열 입력 테스트")
    void testTooShortInput() {
        String input = "//\\n";
        String expectedDelimiters = ",|:";
        CalculatorRequest calculatorRequest = ViewCalculatorParser.parseDelimitersAndInput(input);
        assertThat(calculatorRequest.delimiters()).isEqualTo(expectedDelimiters);
    }
}