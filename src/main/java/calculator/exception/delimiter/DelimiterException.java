package calculator.exception.delimiter;

public class DelimiterException extends IllegalArgumentException {

    public DelimiterException(DelimiterExceptionMessage delimiterExceptionMessage) {
        super(delimiterExceptionMessage.message);
    }
}
