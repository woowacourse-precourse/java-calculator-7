package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DelimiterParserTest {

    @Test
    void parsingDelimiterResultTrue() {
        //given
        String input = "1,2:3";
        //when
        boolean result = DelimiterParser.isDefaultDelimiter(input);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    void parsingDelimiterResultFalse() {
        //given
        String input = "//;\n1;2;3";
        //when
        boolean result = DelimiterParser.isDefaultDelimiter(input);
        //then
        Assertions.assertFalse(result);
    }
    /*@Test
    void splitInputAsString() {
        //given
        String input = "1,2:3";
        //when
        String result = DelimiterParser.splitInputAsString(input);
        //then
        Assertions.assertEquals("123", result);
    }
    @Test
    void getNumbersAfterParsing() {
        //given
        String input = "1,2:3";
        //when
        String result = DelimiterParser.splitInputAsString(input);
        List<Integer> list = DelimiterParser.getNumbersAfterParsing(result);
        //then
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(Integer.valueOf(1), list.getFirst());
    }*/
}