package calculator.front.input;

import calculator.front.parser.CustomDelimiterParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class TotalDelimitedInputTest {

    @Test
    @DisplayName("CustomDelimiterParser 객체가 TotalDelimitedInput으로 반환되어야 함.")
    void 완전_구분된_입력값_테스트() {
        //given
        String rawInput = "//;\\n1:2:3";
        //when
        CustomDelimiterParsedInput customDelimiterParsedInput = CustomDelimiterParser.parse(rawInput);
        TotalDelimitedInput totalDelimitedInput = TotalDelimitedInput.fromCustomDelimiterParseInput(
                customDelimiterParsedInput);
        Character[] customDelimiters = customDelimiterParsedInput.delimiters().toArray(new Character[0]);
        //then
        assertThat(totalDelimitedInput.getDelimiters()).containsAnyOf(customDelimiters);
        assertThat(totalDelimitedInput.getDelimiters()).containsExactly(':', ',', ';');
        assertThat(totalDelimitedInput.getInputWithDelimiters()).isEqualTo(
                customDelimiterParsedInput.inputWithDelimiter());
    }
}