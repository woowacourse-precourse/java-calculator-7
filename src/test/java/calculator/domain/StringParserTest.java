package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
class StringParserTest {

    @Test
    void 기본_구분자로_문자열을_분리한다() {
        //given
        String input = "1,2:3";
        List<String> expected = List.of("1", "2", "3");
        StringParser parser = new StringParser(input);
        String delimiter = parser.extractDelimiter();

        //when
        List<String> actual = parser.parseStrings(delimiter);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void 단일_커스텀_구분자로_문자열을_분리한다() {
        //given
        String input = "//;\\n1;2;3";
        List<String> expected = List.of("1", "2", "3");
        StringParser parser = new StringParser(input);
        String delimiter = parser.extractDelimiter();

        //when
        List<String> actual = parser.parseStrings(delimiter);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void 연속된_커스텀_구분자로_문자열을_분리한다() {
        //given
        String input = "//;;;\\n1;;;2;;;3";
        List<String> expected = List.of("1", "2", "3");
        StringParser parser = new StringParser(input);
        String delimiter = parser.extractDelimiter();

        //when
        List<String> actual = parser.parseStrings(delimiter);

        //then
        assertEquals(expected, actual);
    }

    @Test
    void 메타_문자인_커스텀_구분자로_문자열을_분리한다() {
        //given
        String input = "//?\\n1?2?3";
        List<String> expected = List.of("1", "2", "3");
        StringParser parser = new StringParser(input);
        String delimiter = parser.extractDelimiter();

        //when
        List<String> actual = parser.parseStrings(delimiter);

        //then
        assertEquals(expected, actual);
    }
}
