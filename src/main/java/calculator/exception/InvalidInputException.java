package calculator.exception;

public class InvalidInputException extends IllegalArgumentException {
    private static final String ERROR_PREFIX = "[ERROR]";

    public InvalidInputException(String input, ErrorMessage message) {
        super(String.format("%s %s {:} %s", ERROR_PREFIX, input, message.message));
    }
}
