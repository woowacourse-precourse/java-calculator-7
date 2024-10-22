package calculator.model;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {
    private final InputParser parser = new InputParser(new DelimiterHandler());

    @Test
    @DisplayName("쉼표와 콜론으로 구분된 문자열을 파싱한다")
    void parseInputWithCommaAndColon() {
        String input = "1,2:3";
        String[] result = parser.parseInput(input);
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("빈 문자열 입력 시 빈 배열을 반환한다")
    void returnsEmptyArrayForEmptyInput() {
        String input = "";
        String[] result = parser.parseInput(input);
        assertArrayEquals(new String[]{}, result);
    }
}
