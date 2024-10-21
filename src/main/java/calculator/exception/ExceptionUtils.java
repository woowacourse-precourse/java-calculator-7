package calculator.exception;

public class ExceptionUtils {

    private ExceptionUtils() {
    }

    public static void throwIllegalArgumentException(ErrorStatus errorStatus) {
        throw new IllegalArgumentException(errorStatus.getMessage());
    }
}
