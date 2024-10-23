package calculator.validator.strategies;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.view.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomDelimiterValidatorTest {

    private CustomDelimiterValidator customDelimiterValidator;

    @BeforeEach
    void setUp() {
        // CustomDelimiterValidator 초기화
        customDelimiterValidator = new CustomDelimiterValidator();
    }

    @Test
    void testValidCustomDelimiter() {
        // Given
        String input = "//;" + "\\n" + "1;2;3";  // '\\n'을 사용하여 프로그램 실행과 일치시키기

        // When & Then (예외가 발생하지 않으면 성공)
        assertDoesNotThrow(() -> customDelimiterValidator.validate(input));
    }

    @Test
    void testMissingDelimiter() {
        // Given
        String input = "//" + "\\n" + "1;2;3";

        System.out.println(input);

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            customDelimiterValidator.validate(input);
        });

        assertEquals(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    void testInvalidCustomDelimiterFormat() {
        // Given
        String input = "//;1;2;3"; // 올바르지 않은 커스텀 구분자 형식

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            customDelimiterValidator.validate(input);
        });

        assertEquals(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    void testInvalidEscapeCharacterAsDelimiter() {
        // Given
        String input = "//\\\n1\\2\\3"; // 역슬래시 구분자

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            customDelimiterValidator.validate(input);
        });

        assertEquals(ErrorMessage.INVALID_CUSTOM_DELIMITER_ERROR.getMessage(), exception.getMessage());
    }

}