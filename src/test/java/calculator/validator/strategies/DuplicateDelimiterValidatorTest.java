package calculator.validator.strategies;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.view.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DuplicateDelimiterValidatorTest {

    private DuplicateDelimiterValidator duplicateDelimiterValidator;

    @BeforeEach
    void setUp() {
        // DuplicateDelimiterValidator 초기화
        duplicateDelimiterValidator = new DuplicateDelimiterValidator();
    }

    @Test
    void testValidInputWithNoDuplicateDelimiters() {
        // Given
        String input = "1,2:3"; // 유효한 입력, 중복된 구분자가 없음

        // When & Then (예외가 발생하지 않으면 성공)
        assertDoesNotThrow(() -> duplicateDelimiterValidator.validate(input));
    }

    @Test
    void testInputWithDuplicateComma() {
        // Given
        String input = "1,,2"; // 쉼표가 연속된 입력

        // When & Then (예외가 발생하면 성공)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            duplicateDelimiterValidator.validate(input);
        });
        assertEquals(ErrorMessage.DUPLICATE_DELIMITER_ERROR.getMessage(), exception.getMessage());
    }

    @Test
    void testInputWithDuplicateColon() {
        // Given
        String input = "1::2"; // 콜론이 연속된 입력

        // When & Then (예외가 발생하면 성공)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            duplicateDelimiterValidator.validate(input);
        });
        assertEquals(ErrorMessage.DUPLICATE_DELIMITER_ERROR.getMessage(), exception.getMessage());
    }


}