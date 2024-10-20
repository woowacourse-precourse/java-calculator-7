package calculator;

public class InvalidNumberFormatException extends RuntimeException {
    public InvalidNumberFormatException() {
        throw new IllegalArgumentException();
    }
}
