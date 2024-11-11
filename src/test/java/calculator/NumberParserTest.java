package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberParserTest {

    private final NumberParser numberParser = new NumberParser();

    @Test
    void testParseValidNumber() {
        assertEquals(5, numberParser.parse("5"));
    }

    @Test
    void testParseWithWhitespace() {
        assertEquals(7, numberParser.parse(" 7 "));
    }

    @Test
    void testParseNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> numberParser.parse("-5"));
        assertEquals("음수는 입력할 수 없습니다.", exception.getMessage());
    }

    @Test
    void testParseInvalidNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> numberParser.parse("abc"));
        assertEquals("잘못된 숫자 형식입니다.", exception.getMessage());
    }
}