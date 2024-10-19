package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

}
