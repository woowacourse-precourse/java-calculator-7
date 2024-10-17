package calculator.validate;

public class NumberValidator {

    private static final String POSITIVE_INTEGER_PATTERN = "^[0-9]+$";

    public static void validateNumber(String number) {
        if (!number.matches(POSITIVE_INTEGER_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getMessage());
        }
    }
}
