package calculator.model;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class InputParserTest {
    
    @Test
    void 구분자를_기준으로_문자열_구분_1() {
        List<String> delimiters = List.of(",", ":");
        InputParser inputParser = InputParser.getInstance();
        String[] values = inputParser.parseByDelimiter("1,2:3", delimiters);
        Assertions.assertTrue(Arrays.stream(values).toList().contains("1"));
        Assertions.assertTrue(Arrays.stream(values).toList().contains("2"));
        Assertions.assertTrue(Arrays.stream(values).toList().contains("3"));
    }

    @Test
    void 구분자를_기준으로_문자열_구분_2() {
        List<String> delimiters = List.of(",", ":");
        InputParser inputParser = InputParser.getInstance();
        String[] values = inputParser.parseByDelimiter("1,2:3;4", delimiters);
        Assertions.assertTrue(Arrays.stream(values).toList().contains("1"));
        Assertions.assertTrue(Arrays.stream(values).toList().contains("2"));
        Assertions.assertTrue(Arrays.stream(values).toList().contains("3;4"));
    }
}