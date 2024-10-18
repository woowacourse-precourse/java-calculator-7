package calculator.exception;

public class InvalidDelimiterException extends IllegalArgumentException {
    public InvalidDelimiterException() {
        super("지정하지 않은 구분자가 포함되어 있습니다.");
    }
}
