package calculator.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParserTest {

    private final InputParser parser = InputParser.getInstance();

    @Test
    @DisplayName("커스텀 구분자로 입력을 파싱")
    void testParseWithCustomDelimiter() {
        // Given
        String input = "//;\\n1;2;3";

        // When
        String[] result = parser.parse(input);

        // Then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("기본 구분자로 입력을 파싱")
    void testParseWithDefaultDelimiter() {
        // Given
        String input = "1,2:3";

        // When
        String[] result = parser.parse(input);

        // Then
        assertArrayEquals(new String[]{"1", "2", "3"}, result);
    }

    @Test
    @DisplayName("잘못된 구분자 구문 입력 시 예외 발생")
    void testParseWithInvalidDelimiter() {
        // Given
        String input = "///;\\n1,2:3";

        // When & Then
        assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
    }
}
