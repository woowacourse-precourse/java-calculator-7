package calculator.global.exception;

public class CalculatorException extends IllegalArgumentException {
    private CalculatorException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static CalculatorException of(ErrorMessage errorMessage) {
        return new CalculatorException(errorMessage);
    }
}
