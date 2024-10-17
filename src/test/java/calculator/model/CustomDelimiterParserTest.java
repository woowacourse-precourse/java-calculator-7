package calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CustomDelimiterParserTest {

    @Test
    void 커스텀_구분자_추출_1() {
        String input = "//;\\n1;2;3";
        CustomDelimiterParser customDelimiterParser = CustomDelimiterParser.getInstance();
        String delimiter = customDelimiterParser.parse(input).orElseThrow(NumberFormatException::new);
        Assertions.assertEquals(";", delimiter);
    }

    @Test
    void 커스텀_구분자_추출_2() {
        String input = "//;/\\n1;2;3";
        CustomDelimiterParser customDelimiterParser = CustomDelimiterParser.getInstance();
        String delimiter = customDelimiterParser.parse(input).orElseThrow(NumberFormatException::new);
        Assertions.assertEquals(";/", delimiter);
    }

    @Test
    void 커스텀_구분자_추출_3() {
        String input = "//;/\\\\n1;2;3";
        CustomDelimiterParser customDelimiterParser = CustomDelimiterParser.getInstance();
        String delimiter = customDelimiterParser.parse(input).orElseThrow(NumberFormatException::new);
        Assertions.assertEquals(";/\\", delimiter);
    }
}