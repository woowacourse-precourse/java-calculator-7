package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringParserTest {

    @Test
    void 커스텀_구분자가_존재하는_경우_구분자가_세개가_된다() {
        // given
        StringParser stringParser = new StringParser();
        String input = "//;\n1;2;3";

        // when
        stringParser.addDelimiterFromInput(input);

        // then
        assertThat(stringParser.getDelimiters()).hasSize(3);
    }

    @Test
    void 커스텀_구분자가_2글자_이상인_경우_IllegalArgumentException이_발생한다() {
        // given
        StringParser stringParser = new StringParser();
        String input = "//&^\n1;2;3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> stringParser.addDelimiterFromInput(input));
    }


    @Test
    void 커스텀_구분자가_존재하지_않는_경우_구분자의_수는_2개다() {
        // given
        StringParser stringParser = new StringParser();
        String input = "1,2:3";

        // when
        stringParser.addDelimiterFromInput(input);

        // then
        assertThat(stringParser.getDelimiters()).hasSize(2);
    }

    @Test
    void 적절한_입력이_들어왔을_때_정규표현식이_올바르게_추출된다() {
        // given
        StringParser stringParser = new StringParser();
        String input = "//;\n1;2;3";
        stringParser.addDelimiterFromInput(input);

        // when
        List<String> numbers = stringParser.split(input);

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 적절한_입력이_들어왔을_때_정규표현식이_올바르게_추출된다2() {
        // given
        StringParser stringParser = new StringParser();
        String input = "//&\n1&2&3";
        stringParser.addDelimiterFromInput(input);

        // when
        List<String> numbers = stringParser.split(input);

        // then
        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 적절한_입력이_들어왔을_때_정규표현식이_올바르게_추출된다3() {
        StringParser stringParser = new StringParser();
        String input = "1,2,3";
        stringParser.addDelimiterFromInput(input);

        List<String> numbers = stringParser.split(input);

        assertThat(numbers).isEqualTo(List.of("1", "2", "3"));
    }

    @Test
    void 적절한_입력이_들어왔을_때_정규표현식이_올바르게_추출된다4() {
        StringParser stringParser = new StringParser();
        String input = "";
        stringParser.addDelimiterFromInput(input);

        List<String> numbers = stringParser.split(input);

        assertThat(numbers).isEqualTo(List.of(""));
    }

    @Test
    void 문자열을_입력받아_숫자열로_변환한다() {
        StringParser stringParser = new StringParser();
        String input = "1,2,3";
        stringParser.addDelimiterFromInput(input);

        List<String> numbers = stringParser.split(input);

        assertThat(numbers).isEqualTo(List.of(1, 2, 3));
    }

    @Test
    void 문자열을_입력받아_숫자열로_변환하다_숫자가_아닌_문자가_들어오면_IllegalArgumentException이_발생한다() {
        StringParser stringParser = new StringParser();
        String input = "1,2,a";

        assertThrows(IllegalArgumentException.class, () -> stringParser.split(input));
    }

    @Test
    void 문자열을_입력받아_숫자열로_변환하다_음수가_들어오면_IllegalArgumentException이_발생한다() {
        StringParser stringParser = new StringParser();
        String input = "1,2,-3";

        assertThrows(IllegalArgumentException.class, () -> stringParser.split(input));
    }
}
