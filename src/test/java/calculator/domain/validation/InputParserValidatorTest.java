package calculator.domain.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserValidatorTest {

    @Test
    @DisplayName("입력이 null일 때 IllegalArgumentException 발생")
    void testCheckForNullInputThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            InputParserValidator.checkForEmptyInput(null);
        });
    }

    @Test
    @DisplayName("입력이 빈문자열일 때 예외가 발생하지 않아야 함")
    void testCheckForEmptyInputDoesNotThrowException() {
        assertDoesNotThrow(() -> InputParserValidator.checkForEmptyInput(""));
    }

    @Test
    @DisplayName("공백 문자열 입력 시 공백 제거 결과 확인")
    void testRemoveLeadingAndTrailingSpaces_EmptyString() {
        String input = " ";
        String result = InputParserValidator.removeLeadingAndTrailingSpaces(input);

        assertEquals("", result);
    }

    @Test
    @DisplayName("양쪽 공백 제거된 문자열 확인")
    void testRemoveLeadingAndTrailingSpaces_SpacesAround() {
        String input = " 1:2:3 ";
        String result = InputParserValidator.removeLeadingAndTrailingSpaces(input);

        assertEquals("1:2:3", result);
    }

    @Test
    @DisplayName("양쪽 공백 제거된 문자열 확인")
    void testRemoveLeadingAndTrailingSpaces_ComplexString() {
        String input = " //;\\n1;2;3 ";
        String result = InputParserValidator.removeLeadingAndTrailingSpaces(input);

        assertEquals("//;\\n1;2;3", result);
    }
}
