package calculator.exception;

public class IllegalArgumentException extends RuntimeException {

    public IllegalArgumentException(ErrorMessage errorMessage) {
        super(errorMessage.getErrorMessage());
    }
}
