package calculator.global.util;

import static calculator.global.constant.ErrorMessage.*;


public class Validator {

    public static void ValidateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

}
