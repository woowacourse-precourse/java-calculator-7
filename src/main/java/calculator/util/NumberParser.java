package calculator.util;

public class NumberParser {

    public static int parseAndValidateNumber(String number) {
        number = number.trim();
        if (number.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_EMPTY_INPUT);
        }
        try {
            int intNumber = Integer.parseInt(number);
            if (intNumber < 0) {
                throw new IllegalArgumentException(Constants.ERROR_NEGATIVE_NUMBER);
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_INVALID_NUMBER);
        }
    }
}
