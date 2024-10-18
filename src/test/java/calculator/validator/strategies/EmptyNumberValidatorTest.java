package calculator.validator.strategies;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.view.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmptyNumberValidatorTest {

    private EmptyNumberValidator emptyNumberValidator;

    @BeforeEach
    void setUp() {
        // EmptyNumberValidator 초기화
        emptyNumberValidator = new EmptyNumberValidator();
    }

    @Test
    void testEmptyInput() {
        // Given
        String input = ""; // 빈 입력

        // When & Then (예외가 발생하지 않으면 성공)
        assertDoesNotThrow(() -> emptyNumberValidator.validate(input));
    }

    @Test
    void testWhitespaceInput() {
        // Given
        String input = "   "; // 공백 입력

        // When & Then (예외가 발생하지 않으면 성공)
        assertDoesNotThrow(() -> emptyNumberValidator.validate(input));
    }

    @Test
    void testValidNumericInput() {
        // Given
        String input = "1,2,3"; // 유효한 숫자 입력

        // When & Then (예외가 발생하지 않으면 성공)
        assertDoesNotThrow(() -> emptyNumberValidator.validate(input));
    }


    @Test
    void testNoNumbersButCustomDelimiter() {
        // Given
        String input = "//;" + "\\n";

        // When & Then (예외가 발생하면 성공)
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            emptyNumberValidator.validate(input);
        });
        assertEquals(ErrorMessage.EMPTY_NUMBER_ERROR.getMessage(), exception.getMessage());
    }


}