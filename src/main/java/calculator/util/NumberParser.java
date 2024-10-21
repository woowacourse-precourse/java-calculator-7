package calculator.util;

public class NumberParser {

    public static int parseAndValidateNumber(String number) {
        number = number.trim();
        if (number.isEmpty()) {
            throw new IllegalArgumentException(CustomErrorMessage.ERROR_EMPTY_INPUT);
        }
        try {
            int intNumber = Integer.parseInt(number);
            if (intNumber < 0) {
                throw new IllegalArgumentException(CustomErrorMessage.ERROR_NEGATIVE_NUMBER);
            }
            return intNumber;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CustomErrorMessage.ERROR_INVALID_NUMBER);
        }
    }
}
