package calculator.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefaultStringParserTest {
    private StringParser defaultStringParser;

    @BeforeEach
    void setUp() {
        defaultStringParser = new DefaultStringParser();
    }

    @Test
    void 기본_구분자_입력값을_파싱한다() {
        Long[] result = defaultStringParser.parseToLong("1,2,3");
        assertArrayEquals(new Long[]{1L, 2L, 3L}, result);

        Long[] result2 = defaultStringParser.parseToLong("1:2:3");
        assertArrayEquals(new Long[]{1L, 2L, 3L}, result2);
    }

}