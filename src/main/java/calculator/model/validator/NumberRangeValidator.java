package calculator.model.validator;

import calculator.common.ErrorMessage;
import calculator.exception.CalculatorException;

public class NumberRangeValidator {
    public void validate(int number) {
        if (number > Integer.MAX_VALUE) {
            throw new CalculatorException(ErrorMessage.NUMBER_TOO_LARGE);
        }
    }
}
