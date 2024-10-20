package calculator.common.exception;

public class BusinessException extends IllegalArgumentException {
    public BusinessException(String message) {
        super(message);
    }
}
