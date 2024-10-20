package calculator.exception;

public class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static void throwIllegalArgException(IllegalArgumentExceptionEnum error) {
        throw new IllegalArgumentException(error.getMessage());
    }
}
