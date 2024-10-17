package calculator;

public class Validator {

    private final String errorMessage = "IllegalArgumentException 발생";

    public void isPositive() {
        throw new IllegalStateException("isPositive() : " + errorMessage);
    }

    public void isValidDelimiter() {
        throw new IllegalStateException("isValidDelimiter() : " + errorMessage);

    }

    public void isValidCustomDelimiter() {
        throw new IllegalStateException("isValidCustomDelimiter() : " + errorMessage);
    }

}
