package calculator.validator.strategies;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.view.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NonNumericValidatorTest {

    private NonNumericValidator nonNumericValidator;

    @BeforeEach
    void setUp() {
        // NonNumericValidator 초기화
        nonNumericValidator = new NonNumericValidator();
    }

    @Test
    void testValidNumericInput() {
        // Given
        String input = "1,2,3"; // 유효한 입력

        // When & Then (예외가 발생하지 않으면 성공)
        assertDoesNotThrow(() -> nonNumericValidator.validate(input));
    }

    @Test
    void testInputWithNonNumericCharacters() {
        // Given
        String input = "1,a,3"; // 숫자가 아닌 문자가 포함된 입력

        // When & Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            nonNumericValidator.validate(input);
        });

        assertEquals(ErrorMessage.NON_NUMERIC_INPUT_ERROR.getMessage(), exception.getMessage());
    }
    

}