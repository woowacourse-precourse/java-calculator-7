package calculator.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    private final NumberValidator validator = new NumberValidator();

    @Test
    void testContainsInvalidCharacters() {
        // 유효한 입력 값들
        assertFalse(validator.containsInvalidCharacters("1,2:3"));
        assertFalse(validator.containsInvalidCharacters("//;\n1;2;3"));
        assertFalse(validator.containsInvalidCharacters("//[***]\n1[***]2[***]3"));
        assertFalse(validator.containsInvalidCharacters("//;\n1;2,3"));

        // 잘못된 입력 값들
        assertTrue(validator.containsInvalidCharacters("1,a,3"));
        assertTrue(validator.containsInvalidCharacters("1,  2,  3"));
        assertTrue(validator.containsInvalidCharacters("1;2,3"));
    }
}