package calculator.exception;

public class InvalidDelimiterStrategyException extends IllegalArgumentException {
    private static final String DEFAULT_MESSAGE = "해당 타입에 맞는 전략이 없습니다";

    public InvalidDelimiterStrategyException() {
        super(DEFAULT_MESSAGE);
    }
}
