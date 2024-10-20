package calculator.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    void testIsValidInput() {
        assertTrue(validator.isValidInput("1,2:3"));
        assertTrue(validator.isValidInput("//;\\n1;2;3"));
        assertTrue(validator.isValidInput("//;\\n1;2,3"));
        assertFalse(validator.isValidInput("1,a,3"));
        assertFalse(validator.isValidInput("123a"));
    }
}