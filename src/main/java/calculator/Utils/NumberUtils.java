package calculator.Utils;

import static calculator.Constants.ErrorMessages.INVALID_NUMBER_MESSAGE;

public class NumberUtils {

    NumberUtils() {

    }

    public static void isDouble(String number) {
        try {
            Double.parseDouble(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE.getErrorMessage());
        }
    }

    public static boolean isInt(Double number) {
        return number == (long) (double) number;
    }
}
