package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DelimiterParserTest {

    @Test
    void parsingDelimiterResultTrue() {
        //given
        DelimiterParser delimiterParser = new DelimiterParser();
        String input = "1,2:3";
        //when
        boolean result = delimiterParser.isDefaultDelimiter(input);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    void parsingDelimiterResultFalse() {
        //given
        DelimiterParser delimiterParser = new DelimiterParser();
        String input = "//;\n1;2;3";
        //when
        boolean result = delimiterParser.isDefaultDelimiter(input);
        //then
        Assertions.assertFalse(result);
    }
    @Test
    void splitByDelimiter_defaultDelimiter() {
        //given
        String delimiter = ":";
        DelimiterParser delimiterParser = new DelimiterParser(delimiter);
        String input = "1,2:3";
        //when
        String result = delimiterParser.splitByDelimiter(input);
        //then
        Assertions.assertEquals("1,2,3", result);
    }
    @Test
    void splitByDelimiter_customDelimiter() {
        //given
        String delimiter1 = "//";
        String delimiter2 = "\\n";
        DelimiterParser delimiterParser = new DelimiterParser(delimiter1,delimiter2);
        String input = "//;\\n10;20;30";

        String result = delimiterParser.splitByDelimiter(input);
        String numberPart = result.substring(1);
        String customDelimiter = result.substring(0, 1);
        String[] split = numberPart.split(customDelimiter);
        String splitString = String.join(",", split);
        //when

        //then
        Assertions.assertEquals("10,20,30", splitString);
    }
    @Test
    void getNumbersAfterParsing() {
        //given
        String delimiter = ":";
        DelimiterParser delimiterParser = new DelimiterParser(delimiter);
        String input = "1,2:3";
        //when
        String result = delimiterParser.splitByDelimiter(input);
        List<Integer> list = delimiterParser.parseToIntList(result);
        //then
        Assertions.assertEquals(3, list.size());
        Assertions.assertEquals(Integer.valueOf(1), list.getFirst());
    }
    @Test
    void parseToIntList() {
        //given
        String delimiter = ",";
        DelimiterParser delimiterParser = new DelimiterParser(delimiter);
        String input = "1,2,3";
        //when
        List<Integer> result = delimiterParser.parseToIntList(input);
        //then
        Assertions.assertEquals(3, result.size());
    }
}