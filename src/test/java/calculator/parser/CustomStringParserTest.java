package calculator.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomStringParserTest {
    private StringParser customStringParser;

    @BeforeEach
    void setUp() {
        customStringParser = new CustomStringParser();
    }

    @Test
    void 커스텀_구분자_입력값을_파싱한다() {
        Long[] result = customStringParser.parseToLong("//;\\n1;2;3");
        assertArrayEquals(new Long[]{1L, 2L, 3L}, result);
    }
}