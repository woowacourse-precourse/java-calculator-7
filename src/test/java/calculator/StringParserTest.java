package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @Test
    void 커스텀_구분자로_문자열을_분할할_수_있다() {
        // given
        String input = "//;\n1;2;3";
        StringParser stringParser = new StringParser(input);

        // when
        List<String> numbers = stringParser.split();

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 커스텀_구분자로_문자열을_분할할_수_있다2() {
        // given
        String input = "//&\n1&2&3";
        StringParser stringParser = new StringParser(input);

        // when
        List<String> numbers = stringParser.split();

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 기본_구분자로_문자열을_분할할_수_있다() {
        // given
        String input = "1,2,3";
        StringParser stringParser = new StringParser(input);

        // when
        List<String> numbers = stringParser.split();

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 빈_입력을_처리할_수_있다() {
        // given
        String input = "";
        StringParser stringParser = new StringParser(input);

        // when
        List<String> numbers = stringParser.split();

        // then
        assertThat(numbers).isEqualTo(List.of(""));
    }

    @Test
    void 문자열을_숫자로_변환할_수_있다() {
        // given
        String input = "1,2,3";
        StringParser stringParser = new StringParser(input);
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
        StringParser stringParser = new StringParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, () -> stringParser.split());
    }

    @Test
    void 음수는_예외를_발생시킨다() {
        // given
        String input = "1,2,-3";
        StringParser stringParser = new StringParser(input);

        // when & then
        assertThrows(IllegalArgumentException.class, stringParser::split);
    }
}