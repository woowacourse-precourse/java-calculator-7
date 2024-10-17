package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomDelimiterParserTest {

    @Test
    void parse_1() {
        String input = "//;\\n1;2;3";
        CustomDelimiterParser customDelimiterParser = CustomDelimiterParser.getInstance();
        String delimiter = customDelimiterParser.parse(input);
        Assertions.assertEquals(";", delimiter);
    }

    @Test
    void parse_2() {
        String input = "//;/\\n1;2;3";
        CustomDelimiterParser customDelimiterParser = CustomDelimiterParser.getInstance();
        String delimiter = customDelimiterParser.parse(input);
        Assertions.assertEquals(";/", delimiter);
    }

    @Test
    void parse_3() {
        String input = "//;/\\\\n1;2;3";
        CustomDelimiterParser customDelimiterParser = CustomDelimiterParser.getInstance();
        String delimiter = customDelimiterParser.parse(input);
        Assertions.assertEquals(";/\\", delimiter);
    }
}