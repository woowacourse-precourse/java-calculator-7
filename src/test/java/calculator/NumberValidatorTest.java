package calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.validation.NumberValidator;
import org.junit.jupiter.api.Test;

public class NumberValidatorTest {

    @Test
    void shouldThrowExceptionForNegativeNumber() {
        NumberValidator validator = new NumberValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.validate(-1));
    }

    @Test
    void shouldNotThrowExceptionForPositiveNumber() {
        NumberValidator validator = new NumberValidator();
        assertDoesNotThrow(() -> validator.validate(5));
    }
}
