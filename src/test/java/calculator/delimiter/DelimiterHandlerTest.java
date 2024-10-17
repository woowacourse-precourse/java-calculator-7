package calculator.delimiter;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.converter.EscapeNewLineConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DelimiterHandlerTest {

    private EscapeNewLineConverter escapeNewLineConverter = new EscapeNewLineConverter();

    @Test
    @DisplayName("기본 구분자가 포함된 문자열을 추출할 수 있다.")
    void getNumbersWithDefaultDelimiter() {
        // given
        String input = "1,2:3";
        DelimiterHandler delimiterHandler = new DefaultDelimiterHandler();

        // when
        String numbersWithDelimiter = delimiterHandler.getNumbersWithDelimiter(input);

        // then
        assertThat(numbersWithDelimiter).isEqualTo(input);
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열을 추출할 수 있다.")
    void getNumbersWithCustomDelimiter() {
        // given
        String input = "//t\\n1t2t3t";
        input = escapeNewLineConverter.convert(input);
        DelimiterHandler delimiterHandler = new CustomDelimiterHandler();

        // when
        String numbersWithDelimiter = delimiterHandler.getNumbersWithDelimiter(input);

        // then
        assertThat(numbersWithDelimiter).isEqualTo("1t2t3t");
    }

}