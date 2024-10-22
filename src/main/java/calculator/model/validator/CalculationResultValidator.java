package calculator.model.validator;

import calculator.common.ErrorMessage;
import calculator.exception.CalculatorException;

public class CalculationResultValidator {
    public void validate(long result) {
        if (result > Integer.MAX_VALUE) {
            throw new CalculatorException(ErrorMessage.OUT_OF_RANGE_RESULT);
        }
    }
}
