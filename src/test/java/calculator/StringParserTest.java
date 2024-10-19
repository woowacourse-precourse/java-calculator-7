package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringParserTest {

    private StringParser stringParser;

    @BeforeEach
    void setUp() {
        stringParser = new StringParser();
    }

    @Test
    void 커스텀_구분자를_추가할_수_있다() {
        // given
        String input = "//;\n1;2;3";

        // when
        stringParser.addDelimiterFromInput(input);

        // then
        assertThat(stringParser.getDelimiterCount()).isEqualTo(3);
    }

    @Test
    void 다중_문자_구분자는_예외를_발생시킨다() {
        // given
        String input = "//&^\n1;2;3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> stringParser.addDelimiterFromInput(input));
    }

    @Test
    void 커스텀_구분자가_없으면_구분자는_두_개다() {
        // given
        String input = "1,2:3";

        // when
        stringParser.addDelimiterFromInput(input);

        // then
        assertThat(stringParser.getDelimiterCount()).isEqualTo(2);
    }

    @Test
    void 커스텀_구분자로_문자열을_분할할_수_있다() {
        // given
        String input = "//;\n1;2;3";
        stringParser.addDelimiterFromInput(input);

        // when
        List<String> numbers = stringParser.split(input);

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 커스텀_구분자로_문자열을_분할할_수_있다2() {
        // given
        String input = "//&\n1&2&3";
        stringParser.addDelimiterFromInput(input);

        // when
        List<String> numbers = stringParser.split(input);

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 기본_구분자로_문자열을_분할할_수_있다() {
        // given
        String input = "1,2,3";

        // when
        List<String> numbers = stringParser.split(input);

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 빈_입력을_처리할_수_있다() {
        // given
        String input = "";

        // when
        List<String> numbers = stringParser.split(input);

        // then
        assertThat(numbers).isEqualTo(List.of(""));
    }

    @Test
    void 문자열을_숫자로_변환할_수_있다() {
        // given
        String input = "1,2,3";
        List<String> numbers = stringParser.split(input);

        // when
        List<Integer> convertedNumbers = stringParser.convertToIntArray(numbers);

        // then
        assertThat(convertedNumbers).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 숫자가_아닌_문자는_예외를_발생시킨다() {
        // given
        String input = "1,2,a";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> stringParser.split(input));
    }

    @Test
    void 음수는_예외를_발생시킨다() {
        // given
        String input = "1,2,-3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> stringParser.split(input));
    }
}