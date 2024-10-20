package calculator.view;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputParserTest {

    InputParser inputParser = new InputParser();

    @Test
    @DisplayName("문자열이 입력될 경우 숫자에 해당되는 내용을 분리하고 Numbers 객체로 만들어 반환한다.")
    void parseNumbersWithoutCustomDelimiter() {
        //given
        Delimiters delimiters = new Delimiters();
        String input = "1,2,3";

        // when, then
        assertThat(inputParser.parseNumbers(delimiters, input)).isInstanceOf(Numbers.class);
    }

    @Test
    @DisplayName("문자열이 입력될 경우 숫자에 해당되는 내용을 분리하고 Numbers 객체로 만들어 반환한다.")
    void parseNumbersWithCustomDelimiter() {
        //given
        String input = "//;\\n1;2;3";
        Delimiters delimiters = new Delimiters();
        delimiters.addDelimiter(inputParser.parseCustomDelimiter(input));

        // when, then
        assertThat(inputParser.parseNumbers(delimiters, input)).isInstanceOf(Numbers.class);
    }

    @Test
    @DisplayName("문자열이 입력될 경우 커스텀 구분자를 추출하여 반환한다.")
    void parseCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        String customDelimiter = inputParser.parseCustomDelimiter(input);

        // then
        assertThat(customDelimiter).isEqualTo(";");

    }
}