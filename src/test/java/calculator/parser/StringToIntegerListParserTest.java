package calculator.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class StringToIntegerListParserTest {

    @Test
    void parse_should_be_pass() {
        // given
        String input = "1,2:3";
        StringToIntegerListParser parser = new StringToIntegerListParser();
        // when
        List<Integer> output = parser.parse(input);
        // then
        assertThat(output).containsExactly(1, 2, 3);
        assertThat(parser.getDelimiters()).contains(',', ':');
    }

    @Test
    void parse_with_custom_delim_should_be_pass() {
        // given
        String input = "//;\n1,2:3;4";
        StringToIntegerListParser parser = new StringToIntegerListParser();
        // when
        List<Integer> output = parser.parse(input);
        // then
        assertThat(output).containsExactly(1, 2, 3, 4);
        assertThat(parser.getDelimiters()).contains(',', ':', ';');
    }

    @Test
    void parse_with_custom_delims_should_be_pass() {
        // given
        String input = "//;\n//_\n//~\n1,2:3;4_5~6";
        StringToIntegerListParser parser = new StringToIntegerListParser();
        // when
        List<Integer> output = parser.parse(input);
        // then
        assertThat(output).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(parser.getDelimiters()).contains(',', ':', ';', '_', '~');
    }

    @Test
    void parse_with_custom_delims_2_should_be_pass() {
        // given
        String input = "//;\n//_^\n//~$\n1,2:3;4_5^6~7$8";
        StringToIntegerListParser parser = new StringToIntegerListParser();
        // when
        List<Integer> output = parser.parse(input);
        // then
        assertThat(output).containsExactly(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(parser.getDelimiters()).contains(',', ':', ';', '_', '^', '~', '$');
    }

    @Test
    void parse_when_숫자가_아닌_입력값_throws_IllegalArgumentException() {
        // given
        String input = "1,2:str";
        StringToIntegerListParser parser = new StringToIntegerListParser();
        // when
        // then
        assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
    }

}
