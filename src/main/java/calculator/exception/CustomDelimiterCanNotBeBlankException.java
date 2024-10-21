package calculator.exception;

public class CustomDelimiterCanNotBeBlankException extends IllegalArgumentException {
    public CustomDelimiterCanNotBeBlankException(String s) {
        super(s);
    }
}
