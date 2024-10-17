package calculator.validator.strategies;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.view.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NegativeNumberValidatorTest {

    private NegativeNumberValidator negativeNumberValidator;

    @BeforeEach
    void setUp() {
        // NegativeNumberValidator 초기화
        negativeNumberValidator = new NegativeNumberValidator();
    }

    @Test
    void testValidInput() {
        // Given
        String input = "1,2,3"; // 유효한 입력

        // When & Then (예외가 발생하지 않으면 성공)
        assertDoesNotThrow(() -> negativeNumberValidator.validate(input));
    }

    @Test
    void testNegativeNumber() {
        // Given
        String input = "1,-2,3"; // 음수를 포함한 입력

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            negativeNumberValidator.validate(input);
        });

        assertEquals(ErrorMessage.NEGATIVE_NUMBER_ERROR.getMessage() + ": -2", exception.getMessage());
    }

    @Test
    void testMultipleNegativeNumbers() {
        // Given
        String input = "-1,-2,3"; // 여러 음수를 포함한 입력

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            negativeNumberValidator.validate(input);
        });

        assertEquals(ErrorMessage.NEGATIVE_NUMBER_ERROR.getMessage() + ": -1, -2", exception.getMessage());
    }

}