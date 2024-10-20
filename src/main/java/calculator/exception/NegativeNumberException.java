package calculator.exception;

public class NegativeNumberException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "음수는 허용되지 않습니다.";

    public NegativeNumberException() {
        super(DEFAULT_MESSAGE);
    }
}
