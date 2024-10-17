package calculator.Utils;

import calculator.Constants.ErrorMessages;

public class NumberUtils {

    public static void isDouble(String number) {
        try {
            Double parsedNumber = Double.parseDouble(number);
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessages.INVALID_NUMBER_MESSAGE.getErrorMessage());
        }
    }
}
