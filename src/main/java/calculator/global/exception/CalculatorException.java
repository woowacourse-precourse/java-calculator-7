package calculator.global.exception;

import calculator.global.message.ErrorMessage;

public class CalculatorException extends IllegalArgumentException {
    private CalculatorException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static CalculatorException from(ErrorMessage errorMessage) {
        return new CalculatorException(errorMessage);
    }
}