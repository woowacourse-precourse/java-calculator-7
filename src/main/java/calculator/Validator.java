package calculator;

public class Validator {

    private static final String ERROR_MESSAGE = "IllegalArgumentException 발생";

    public void isPositive() {
        throw new IllegalStateException("isPositive() : " + ERROR_MESSAGE);
    }

    public void isValidDelimiter() {
        throw new IllegalStateException("isValidDelimiter() : " + ERROR_MESSAGE);

    }

    public void isValidCustomDelimiter() {
        throw new IllegalStateException("isValidCustomDelimiter() : " + ERROR_MESSAGE);
    }

}
