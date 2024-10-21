package calculator.exception;

public class CalculatorException extends IllegalArgumentException{
    public CalculatorException(CalculatorExceptionStatus errorMessage) {
        super(errorMessage.getMessage());
    }
}
