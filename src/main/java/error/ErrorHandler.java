package error;

public class ErrorHandler {

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }

    }
}
