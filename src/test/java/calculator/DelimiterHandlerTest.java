package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DelimiterHandlerTest {

    @DisplayName("//;\\n1;2;3를 입력하면 구분자와 계산식이 분리되어 출력됨을 테스트하라")
    @Test
    void test_extractCustomDelimiterAndNumbers() {
        DelimiterHandler delimiterHandler = new DelimiterHandler();

        DelimiterAndNumber delimiterAndNumber = delimiterHandler.extractCustomDelimiterAndNumbers("//;\\n1;2;3");

        assertThat(delimiterAndNumber.delimiters()).isEqualTo(":|,|\\Q;\\E");
        assertThat(delimiterAndNumber.numbersString()).isEqualTo("1;2;3");
    }

    @DisplayName("//;;\\n1;2;3를 입력하면 예외처리됨을 테스트하라")
    @Test
    void test_extractCustomDelimiterAndNumbers_with_wrong_input() {
        String input = "//;;\\n1;2;3";
        DelimiterHandler delimiterHandler = new DelimiterHandler();

        assertThatThrownBy(() ->
                delimiterHandler.extractCustomDelimiterAndNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("커스텀 구분자는 한글자이어야 합니다.");
    }

    @DisplayName("기본 구분자 외 다른 구분자를 사용해 입력하면, 예외처리됨을 테스트하라")
    @Test
    void test_validateDefaultDelimiter() {
        String input = "1!2!3";
        DelimiterHandler delimiterHandler = new DelimiterHandler();
        assertThatThrownBy(() ->
                delimiterHandler.validateDefaultDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("(%s)에서는 허용되지 않는 구분자가 발견되었습니다. ([!, !])", input));

    }

    @DisplayName("처음 계산식에 숫자가 아닌 값이 들어가면 예외를 반환하는 메서드를 테스트하라")
    @Test
    void test_validateDefaultDelimiter2() {
        String input = ":1:2:3";
        DelimiterHandler delimiterHandler = new DelimiterHandler();
        assertThatThrownBy(() ->
                delimiterHandler.validateDefaultDelimiter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력 문자열이 잘못되었습니다: 입력의 첫 글자가 기본 구분자입니다.");

    }
}
