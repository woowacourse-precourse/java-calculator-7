package calculator.exception;

import calculator.common.ErrorMessage;

public class CalculatorException extends IllegalArgumentException{
    public CalculatorException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
