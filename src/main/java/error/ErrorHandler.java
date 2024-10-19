package error;

public class ErrorHandler {

    public static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }
    }


    public static void validateOnlyDigits(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number must be an integer");
        }
    }
}
