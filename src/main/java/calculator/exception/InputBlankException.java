package calculator.exception;

public class InputBlankException extends IllegalArgumentException {
    public InputBlankException(String s) {
        super(s);
    }
}
