package calculator.exception;

public class ExceptionHandler {

    public static void throwIllegalArgException(ErrorMessage error, String value) {
        throw new IllegalArgumentException(String.format(error.getMessage(), value));
    }

    public static void throwIllegalArgException(ErrorMessage error) {
        throw new IllegalArgumentException(error.getMessage());
    }
}
