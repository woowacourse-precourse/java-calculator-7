package calculator.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmptyStringParserTest {
    private StringParser emptyStringParser;

    @BeforeEach
    void setUp() {
        emptyStringParser = new EmptyStringParser();
    }

    @Test
    void 빈_문자열을_파싱하면_빈_배열을_반환한다() {
        Long[] result = emptyStringParser.parseToLong("");
        assertArrayEquals(new Long[0], result);
    }
}