package calculator;

import calculator.model.StringParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringParserTest {

    private StringParser stringParser = new StringParser();

    @Test
    void 공백_문자일시_예외를_던진다() {
        String blank = "";

        assertThrows(IllegalArgumentException.class, () -> {
            stringParser.validateBlank(blank);
        });
    }

    @Test
    void 공백_문자가_아닐시_예외를_던지지않는다() {
        // Given
        String notBlank = "Not Blank";  // 빈 문자열이 아닌 유효한 문자열

        // When & Then
        assertDoesNotThrow(() -> {
            stringParser.validateBlank(notBlank);
        });
    }

    @Test
    void 빈문자일시_false를_반환하다() {
        boolean expectedFalse = false;
        String blank = "Not Blank";

        boolean actual = stringParser.isBlank(blank);

        assertEquals(expectedFalse, actual);
    }

    @Test
    void 빈문자일시_true를_반환하다() {
        boolean expectedTrue = true;
        String blank = "";

        boolean actual = stringParser.isBlank(blank);

        assertEquals(expectedTrue, actual);
    }
}
