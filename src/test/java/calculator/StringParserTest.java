package calculator;

import calculator.model.StringParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    private StringParser stringParser = new StringParser();

    @Test
    void 공백문자가_아닐시_false를_반환하다() {
        boolean expectedFalse = false;
        String notBlank = "Not Blank";

        boolean actual = stringParser.isBlank(notBlank);

        assertEquals(expectedFalse, actual);
    }

    @Test
    void 공백문자일시_true를_반환하다() {
        boolean expectedTrue = true;
        String blank = "";

        boolean actual = stringParser.isBlank(blank);

        assertEquals(expectedTrue, actual);
    }
}
