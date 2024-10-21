package calculator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.StringExpression;
import calculator.validation.ExpressionValidator;
import org.junit.jupiter.api.Test;

public class ExpressionValidatorTest {

    @Test
    void shouldThrowExceptionForInvalidExpression() {
        ExpressionValidator validator = new ExpressionValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.validate(new StringExpression("1,,2")));
    }

    @Test
    void shouldNotThrowExceptionForValidExpression() {
        ExpressionValidator validator = new ExpressionValidator();
        assertDoesNotThrow(() -> validator.validate(new StringExpression("1,2,3")));
    }
}
