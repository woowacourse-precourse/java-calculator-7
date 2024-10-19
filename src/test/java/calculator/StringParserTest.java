package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringParserTest {

    private StringParser stringParser;

    @ParameterizedTest
    @CsvSource({
            "'//;\n1;2;3', '1,2,3'",
            "'//&\n1&2&3', '1,2,3'",
            "'1,2,3', '1,2,3'"
    })
    void 문자열을_올바르게_분할해야_한다(String input, String expected) {
        // given
        stringParser = new StringParser(input);

        // when
        List<String> numbers = stringParser.split();

        // then
        assertThat(numbers).isEqualTo(List.of(expected.split(",")));
    }

    @Test
    void 빈_입력을_처리할_수_있다() {
        // given
        String input = "";
        stringParser = new StringParser(input);

        // when
        List<String> numbers = stringParser.split();

        // then
        assertThat(numbers).isEqualTo(List.of(""));
    }

    @Test
    void 문자열을_숫자로_변환할_수_있다() {
        // given
        String input = "1,2,3";
        stringParser = new StringParser(input);
        List<String> numbers = stringParser.split();

        // when
        List<Integer> convertedNumbers = stringParser.convertToIntArray(numbers);

        // then
        assertThat(convertedNumbers).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 숫자가_아닌_문자는_예외를_발생시킨다() {
        // given
        String input = "1,2,a";
        stringParser = new StringParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> stringParser.split());
    }

    @Test
    void 음수는_예외를_발생시킨다() {
        // given
        String input = "1,2,-3";
        stringParser = new StringParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, stringParser::split);
    }
}