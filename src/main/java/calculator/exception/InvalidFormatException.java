package calculator.exception;

public class InvalidFormatException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "정확한 형식의 값을 입력해주세요.";

    public InvalidFormatException() {
        super(DEFAULT_MESSAGE);
    }
}