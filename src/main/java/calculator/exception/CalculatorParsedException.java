package calculator.exception;

public class CalculatorParsedException extends IllegalArgumentException {
    static final String MESSAGE = "올바르지않은 구분자입니다.";

    public CalculatorParsedException() {
        this(MESSAGE);
    }

    public CalculatorParsedException(String message) {
        super(message);
    }
}
