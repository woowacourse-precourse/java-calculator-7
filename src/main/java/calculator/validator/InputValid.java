package calculator.validator;

import calculator.constant.ValidConstants;
import calculator.exception.InputValidationException;

public class InputValid {
    // 전체 글자 길이 제한 1 -100
    public static void checkStringLength(String str) {
        if (str.length() > ValidConstants.MAX_TOTAL_LENGTH) {
            throw new IllegalArgumentException(InputValidationException.TOO_LONG_STRING.getMessage());
        }
        if (str.isEmpty()) {
            throw new IllegalArgumentException(InputValidationException.EMPTY_STRING.getMessage());
        }
    }

    public static boolean isValidCustomSeparatorFormat(String input) {
        return ValidConstants.CUSTOM_SEPARATOR_PATTERN.matcher(input).matches();
    }



    // 커스텀 구분자 길이 제한
    public static void checkCustomSeparatorLength(String separator) {
        if (separator.length() > ValidConstants.MAX_SEPARATOR_LENGTH) {
            throw new IllegalArgumentException(InputValidationException.TOO_LONG_CUSTOM_SEPARATOR.getMessage());
        }
        if (separator.isEmpty()) {
            throw new IllegalArgumentException(InputValidationException.EMPTY_CUSTOM_SEPARATOR.getMessage());
        }
    }

    // 구분자 기준으로 잘랐을 때 내부 글자 -  숫자만 있는가? / 숫자의 길이는?
    public static String checkNumber(String number) {
        if (!number.matches(ValidConstants.NUMBER_PATTERN)) {
            throw new IllegalArgumentException(InputValidationException.INVALID_NUMBER_FORMAT.getMessage());
        }
        return number;
    }

    // 숫자 개수 제한
    public static void checkNumberCount(int count) {
        if (count == 0) {
            throw new IllegalArgumentException(InputValidationException.NO_NUMBERS.getMessage());
        }
        if (count > ValidConstants.MAX_NUMBER_COUNT) {
            throw new IllegalArgumentException(InputValidationException.TOO_MANY_NUMBERS.getMessage());
        }
    }
}