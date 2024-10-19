package calculator.delimiter;

import calculator.parser.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DelimiterTest {

    private final Delimiter delimiter = Delimiter.getInstance();

    @Test
    @DisplayName("커스텀 구분자를 올바르게 추출")
    void testExtractDelimiterWithCustomSyntax() {
        // Given
        String input = "//;\\n1;2;3";

        // When
        String result = delimiter.extractDelimiter(input);

        // Then
        assertEquals(";", result);
    }

    @Test
    @DisplayName("구분자 구문 제거 테스트")
    void testRemoveDelimiterSyntax() {
        // Given
        String input = "//;\\n1;2;3";

        // When
        String result = delimiter.removeDelimiterSyntax(input);

        // Then
        assertEquals("1;2;3", result);
    }

    @Test
    @DisplayName("기본 또는 커스텀 구분자 유효성 테스트")
    void testValidateHasDefaultOrCustomDelimiter() {
        // Given
        String input = "//;\\n1;2;3";

        // When & Then
        assertTrue(delimiter.validateHasDefaultOrCustomDelimiter(input, ";"));
    }

    @Test
    @DisplayName("잘못된 구분자 입력 시 실패")
    void testValidateInvalidDelimiter() {
        // Given
        String input = "//;\\n1,2;3";

        // When & Then
        assertFalse(delimiter.validateHasDefaultOrCustomDelimiter(input, "|"));
    }
}
