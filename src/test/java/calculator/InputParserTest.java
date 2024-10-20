package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @Test
    void parsingDelimiterResultTrue() {
        //given
        InputParser parser = new InputParser();
        String input = "1,2:3";
        //when
        boolean result = parser.hasDefaultDelimiters(input);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    void parsingDelimiterResultFalse() {
        //given
        InputParser parser = new InputParser();
        String input = "//;\n1;2;3";
        //when
        boolean result = parser.hasDefaultDelimiters(input);
        //then
        Assertions.assertFalse(result);
    }
}