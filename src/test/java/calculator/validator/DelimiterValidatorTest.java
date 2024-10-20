package calculator.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DelimiterValidatorTest {

    private final DelimiterValidator validator = new DelimiterValidator();

    @Test
    void testHasConsecutiveDelimiters() {
        // 연속된 구분자가 있는 경우
        assertTrue(validator.hasConsecutiveDelimiters("1,,2", ","));
        assertTrue(validator.hasConsecutiveDelimiters("1::2", ":"));

        // 연속된 구분자가 없는 경우
        assertFalse(validator.hasConsecutiveDelimiters("1,2", ","));
        assertFalse(validator.hasConsecutiveDelimiters("1:2", ":"));

        // 문자열에 구분자가 없을 경우
        assertFalse(validator.hasConsecutiveDelimiters("12345", ","));

        // 빈 문자열 테스트
        assertFalse(validator.hasConsecutiveDelimiters("", ","));

    }

    @Test
    void testContainsInvalidDelimiters() {
        // 연속된 구분자가 있는 경우
        assertTrue(validator.containsInvalidDelimiters("1,,2"));
        assertTrue(validator.containsInvalidDelimiters("1::::2"));

        // 커스텀 구분자가 없는 경우
        assertFalse(validator.containsInvalidDelimiters("1,2"));
        assertFalse(validator.containsInvalidDelimiters("1:2"));

        // 커스텀 구분자가 있는 경우 (valid)
        assertFalse(validator.containsInvalidDelimiters("//;\n1;2;3"));

        // 빈 문자열
        assertFalse(validator.containsInvalidDelimiters(""));

    }
}