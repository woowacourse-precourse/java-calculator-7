package calculator;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.model.StringExpression;
import calculator.service.ValidatorFactory;
import calculator.validation.ExpressionValidator;
import calculator.validation.NumberValidator;
import calculator.validation.Validator;
import org.junit.jupiter.api.Test;

public class ValidatorFactoryTest {

    @Test
    void shouldReturnExpressionValidatorForStringExpressionClass() {
        Validator validator = ValidatorFactory.getValidator(StringExpression.class);
        assertTrue(validator instanceof ExpressionValidator);
    }

    @Test
    void shouldReturnNumberValidatorForIntegerClass() {
        Validator validator = ValidatorFactory.getValidator(Integer.class);
        assertTrue(validator instanceof NumberValidator);
    }

    @Test
    void shouldThrowExceptionForUnknownValidatorType() {
        assertThrows(IllegalArgumentException.class, () -> ValidatorFactory.getValidator(Double.class));
    }
}
