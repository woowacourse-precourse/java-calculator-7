package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    InputParser parser = new InputParser();

    @Test
    void parseDefaultDelimiter() {
        String input = "1,2:3";
        String[] expected = {"1", "2", "3"};
        assertArrayEquals(expected, parser.parseTokens(input));
    }

    @Test
    void parseCustomDelimiter() {
        // 테스트 코드에서는 이스케이프 처리 때문에 두 번의 백슬래시 필요
        String input = "//;;\\n1;;2;;3";
        String[] expected = {"1", "2", "3"};
        assertArrayEquals(expected, parser.parseTokens(input));
    }

    @Test
    void parseEmptyInput() {
        String input = "";
        String[] expected = {"0"};
        assertArrayEquals(expected, parser.parseTokens(input));
    }

    @Test
    void parseInvalidCustomDelimiter() {
        String input = "//;\n1;2;";
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class,
                        () -> parser.parseTokens(input));
        assertEquals("커스텀 구분자 형식이 잘못되었습니다.", exception.getMessage());
    }
}
