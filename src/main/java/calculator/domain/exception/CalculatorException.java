package calculator.domain.exception;

public class CalculatorException extends IllegalArgumentException {
    private CalculatorException(CalculatorErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }

    public static CalculatorException from(CalculatorErrorMessage errorMessage) {
        return new CalculatorException(errorMessage);
    }
}
