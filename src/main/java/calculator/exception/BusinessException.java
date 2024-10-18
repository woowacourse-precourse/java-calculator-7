package calculator.exception;

public class BusinessException extends IllegalArgumentException {

    public BusinessException(final CalculatorExceptionMessage message) {
        super(message.getErrorMessage());
    }
}
