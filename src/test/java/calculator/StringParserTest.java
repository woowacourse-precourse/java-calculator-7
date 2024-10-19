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
    void 문자열을_숫자열로_올바르게_분할해야_한다(String input, String expected) {
        // given
        stringParser = new StringParser(input);

        // when
        List<Integer> numbers = stringParser.parse();

        // then
        assertThat(numbers).isEqualTo(List.of(expected.split(",")).stream()
                .map(Integer::parseInt)
                .toList());
    }

    @Test
    void 빈_문자열을_입력하는_경우_0을_리스트에_담아_반환한다() {
        // given
        String input = "";
        stringParser = new StringParser(input);

        // when
        List<Integer> numbers = stringParser.parse();

        // then
        assertThat(numbers).isEqualTo(List.of(0));
    }

    @Test
    void 숫자가_아닌_문자는_예외를_발생시킨다() {
        // given
        String input = "1,2,a";
        stringParser = new StringParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, stringParser::parse);
    }

    @Test
    void 음수는_예외를_발생시킨다() {
        // given
        String input = "1,2,-3";
        stringParser = new StringParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, stringParser::parse);
    }
}