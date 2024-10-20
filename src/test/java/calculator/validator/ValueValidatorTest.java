package calculator.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ValueValidatorTest {

    private final ValueValidator validator = new ValueValidator();

    @Test
    void testHasValue() {
        assertFalse(validator.hasValue(""));
        assertFalse(validator.hasValue("//;\n"));
        assertTrue(validator.hasValue("1,2:3"));
        assertTrue(validator.hasValue("//;\n1;2;3"));
    }

    @Test
    void testIsLastDigit() {
        assertTrue(validator.isLastDigit("1,2:3"));
        assertTrue(validator.isLastDigit("//;\n1;2;3"));
        assertFalse(validator.isLastDigit("//;\n1;2;3a"));
        assertFalse(validator.isLastDigit("123a"));
    }
}