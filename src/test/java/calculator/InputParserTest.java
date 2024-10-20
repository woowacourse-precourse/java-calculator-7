package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class InputParserTest {

    InputParser inputParser = new InputParser();

    @Test
    void 기본_구분자로_파싱() {
        String input = "1,2:3";
        String[] result = inputParser.parse(input);

        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }
    @Test
    void 커스텀_구분자로_파싱() {
        String input = "//;\n1;2;3";
        String[] result = inputParser.parse(input);

        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }
}
