package calculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputSanitizerTest {

    @Test
    @DisplayName("커스텀 구분자가 있을 때 입력을 올바르게 정리한다")
    void sanitizeInputWithCustomDelimiter() {
        InputSanitizer sanitizer = new InputSanitizer();
        String input = "//;\n1;2;3";
        String sanitizedInput = sanitizer.sanitizeInput(input, "//", "\n");

        assertEquals("1;2;3", sanitizedInput);
    }

    @Test
    @DisplayName("커스텀 구분자가 없을 때 입력을 그대로 반환한다")
    void sanitizeInputWithoutCustomDelimiter() {
        InputSanitizer sanitizer = new InputSanitizer();
        String input = "1,2,3";
        String sanitizedInput = sanitizer.sanitizeInput(input, "//", "\n");

        assertEquals("1,2,3", sanitizedInput);
    }

    @Test
    @DisplayName("구분자가 역순일 때도 올바르게 처리한다")
    void sanitizeInputWithReversedDelimiters() {
        InputSanitizer sanitizer = new InputSanitizer();
        String input = "\n//1,2,3";
        String sanitizedInput = sanitizer.sanitizeInput(input, "//", "\n");

        assertEquals("1,2,3", sanitizedInput);
    }

}
