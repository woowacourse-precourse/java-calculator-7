package calculator.exception;

public class BusinessException extends Exception{

    public BusinessException(final CalculatorExceptionMessage message) {
        super(message.getErrorMessage());
    }
}
