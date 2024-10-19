package calculator.exception;

public class CalculatorParsedException extends IllegalArgumentException {
    static final String MESSAGE = "올바르지않은 구분자입니다.";
    public static final String CUSTOM_NOT_EMPTY = "커스텀 구분자로 빈 값이 올 수 없습니다.";
    public static final String CUSTOM_OVER_LENGTH = "커스텀 구분자는 %d자를 초과할 수 없습니다.";
    public static final String CUSTOM_NOT_NUMERIC = "커스텀 구분자로 숫자가 올 수 없습니다.";
    public static final String NOT_NUMERIC = "양의 정수만 계산할 수 있습니다.";

    public CalculatorParsedException() {
        this(MESSAGE);
    }

    public CalculatorParsedException(String message) {
        super(message);
    }
}
