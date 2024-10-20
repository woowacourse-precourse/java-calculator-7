package calculator.exception;

public class CalculatorParsedException extends IllegalArgumentException {
    public static final String EMPTY_CUSTOM_DELIMITER = "커스텀 구분자로 빈 값이 올 수 없습니다.";
    public static final String CUSTOM_NOT_NUMERIC = "커스텀 구분자로 숫자가 올 수 없습니다.";
    public static final String POSITIVE_EXPRESSION = "양의 정수만 계산할 수 있습니다.";
    public static final String EMPTY_EXPRESSION = "표현식에 빈 값이 올 수 없습니다.";

    public CalculatorParsedException(String message) {
        super(message);
    }
}
