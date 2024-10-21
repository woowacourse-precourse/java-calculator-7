package calculator.exception;

public class CustomDelimiterLengthMustBeOneException extends IllegalArgumentException {
    public CustomDelimiterLengthMustBeOneException(String s) {
        super(s);
    }
}
