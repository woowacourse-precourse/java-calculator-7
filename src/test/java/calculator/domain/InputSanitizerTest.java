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
}
