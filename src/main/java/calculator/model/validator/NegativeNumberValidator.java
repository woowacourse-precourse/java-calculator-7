package calculator.model.validator;

import calculator.common.ErrorMessage;
import calculator.exception.CalculatorException;

public class NegativeNumberValidator {
    public void validate(int number) {
        if (number < 0) {
            throw new CalculatorException(ErrorMessage.NEGATIVE_NUMBER);
        }
    }
}
