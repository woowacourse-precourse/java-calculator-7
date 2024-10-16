package calculator;

import calculator.model.StringParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringParserTest {

    private StringParser stringParser = new StringParser();

    @Test
    void 빈문자일시_false를_반환하다() {
        boolean expectedFalse = false;
        String blank = "Not Blank";

        boolean actual = stringParser.isBlank(blank);

        assertEquals(expectedFalse, actual);
    }

    @Test
    void 빈문자일시_true를_반환하다() {
        boolean expectedTrue = true;
        String blank = "";

        boolean actual = stringParser.isBlank(blank);

        assertEquals(expectedTrue, actual);
    }
}
