package calculator.exception;

public class InvalidDelimiterException extends IllegalArgumentException {
    public InvalidDelimiterException() {
        super("쉼표(,) 또는 콜론(:) 외의 다른 구분자는 사용할 수 없으며, 숫자 사이에만 올 수 있습니다.");
    }
}
