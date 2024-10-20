package calculator.exception;

public class CalculatorException extends IllegalArgumentException {
    public CalculatorException(CalculatorErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
