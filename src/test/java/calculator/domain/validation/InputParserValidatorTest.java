package calculator.domain.validation;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
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

}
