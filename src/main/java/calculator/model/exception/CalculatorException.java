package calculator.model.exception;

public class CalculatorException extends IllegalArgumentException {
    public CalculatorException(CalculatorErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}
