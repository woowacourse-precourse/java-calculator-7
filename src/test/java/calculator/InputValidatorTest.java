package calculator;

import calculator.model.InputValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputValidatorTest {

    InputValidator validator = new InputValidator();

    @Test
    void testValidInputWithDefaultDelimiter() {
        assertDoesNotThrow(() -> validator.validate("1,2:3"));
    }

    @Test
    void testValidInputWithCustomDelimiter() {
        assertDoesNotThrow(() -> validator.validate("//;\\n1;2;3"));
    }

    @Test
    void testNegativeNumberThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("1,-2,3"));
    }

    @Test
    void testEmptyInput() {
        assertDoesNotThrow(() -> validator.validate(""));
    }

    @Test
    void testInvalidFormatThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("//;\n1;2,-3"));
    }
}

