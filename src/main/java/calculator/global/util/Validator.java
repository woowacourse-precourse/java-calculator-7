package calculator.global.util;

import static calculator.global.constant.ErrorMessage.*;


public class Validator {

    public static void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR_MESSAGE);
        }
    }

    public static void validateExtractedNumber(String number) {
        try {
            validateNumberFormat(number);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(UNREGISTERED_SEPARATOR_ERROR_MESSAGE);
        }
        validateDashNumber(number);
    }

    private static void validateDashNumber(String number) {
        int absNum = Math.abs(Integer.parseInt(number));
        if(Integer.parseInt(number) != absNum){
            throw new IllegalArgumentException(UNREGISTERED_SEPARATOR_ERROR_MESSAGE);
        }
    }
}
