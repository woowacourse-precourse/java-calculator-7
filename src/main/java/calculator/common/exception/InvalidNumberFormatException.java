package calculator.common.exception;

public class InvalidNumberFormatException extends IllegalArgumentException {
    private static final String INVALID_FORMAT = "잘못된 입력 값: ";

    public InvalidNumberFormatException(String token) {
        super(INVALID_FORMAT + token);
    }
}