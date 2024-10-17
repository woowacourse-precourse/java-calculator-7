package calculator.model;

import java.util.List;
import org.junit.jupiter.api.Test;

class InputParserTest {
    private InputParser inputParser = InputParser.getInstance();

    @Test
    void parseByDelimiter() {
        List<String> delimiters = List.of(",", ":");
        String[] values = inputParser.parseByDelimiter("1,2:3", delimiters);
        for (String value : values) {
            System.out.println(value);
        }
    }
}