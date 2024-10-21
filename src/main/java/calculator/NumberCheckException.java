package calculator;

public class NumberCheckException extends RuntimeException {
    public NumberCheckException() {
        super();
    }

    public NumberCheckException(Throwable cause) {
        super(cause);
    }

    public NumberCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberCheckException(String message) {
        super(message);
    }
}
