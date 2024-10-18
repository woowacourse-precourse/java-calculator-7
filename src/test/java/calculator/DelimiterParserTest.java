package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DelimiterParserTest {

    @Test
    void parsingDelimiterResultTrue() {
        //given
        String input = "1,2:3";
        //when
        boolean result = DelimiterParser.hasDefaultDelimiters(input);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    void parsingDelimiterResultFalse() {
        //given
        String input = "//;\n1;2;3";
        //when
        boolean result = DelimiterParser.hasDefaultDelimiters(input);
        //then
        Assertions.assertFalse(result);
    }
}